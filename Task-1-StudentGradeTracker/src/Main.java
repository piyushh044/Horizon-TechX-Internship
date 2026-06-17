import java.util.Scanner;

public class Main {

    static GradeTrackerService service = new GradeTrackerService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("====================================");

        boolean running=true;

        while (running){

            printMenu();

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addStudent();
                    break;

                case "2":
                    addGrade();
                    break;

                case "3":
                    viewAllStudents();
                    break;

                case "4":
                    showDetailedSummary();
                    break;

                case "5":
                    running = false;
                    System.out.println("Thank you for using the Grade Tracker.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void printMenu() {

        System.out.println("\n----- MAIN MENU -----");
        System.out.println("1. Add Student");
        System.out.println("2. Add Grade");
        System.out.println("3. View All Students");
        System.out.println("4. Show Summary Report");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void addStudent() {

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        if(name.trim().isEmpty()){
            System.out.println("Student name cannot be empty.");
            return;
        }

        boolean added = service.addStudent(name);

        if(added){
            System.out.println("Student added successfully.");
        } 

        else{
            System.out.println("Student already exists.");
        }
    }

    public static void addGrade() {

        if(service.getStudents().size() == 0){
            System.out.println("No students found. Add a student first.");
            return;
        }


        System.out.println("\nStudents:");


        for(int i = 0; i < service.getStudents().size(); i++){

            Student student = service.getStudents().get(i);

            System.out.println((i + 1) + ". " + student.getName());
        }

        int index;

        try{

            System.out.print("Select student number: ");
            index = Integer.parseInt(scanner.nextLine()) - 1;

        } 
        
        catch(NumberFormatException e){

            System.out.println("Please enter a valid number.");
            return;
        }

        double grade;

        try{

            System.out.print("Enter grade (0-100): ");
            grade = Double.parseDouble(scanner.nextLine());

        } 
        
        catch(NumberFormatException e){

            System.out.println("Please enter a valid grade.");
            return;
        }

        boolean added = service.addGrade(index, grade);

        if(added){

            Student student = service.getStudents().get(index);

            System.out.println("Grade added for " + student.getName());

        }
        
        else{

            System.out.println("Invalid student number or grade.");
        }
    }

    public static void viewAllStudents() {

        if(service.getStudents().size() == 0){
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n----- STUDENT LIST -----");

        for(Student student : service.getStudents()){

            System.out.println(student);
        }
    }

    public static void showDetailedSummary(){

        if(service.getStudents().size() == 0){

            System.out.println("No data available.");
            return;
        }

        System.out.println("\n====================================");
        System.out.println("       SUMMARY REPORT");
        System.out.println("====================================");

        for(Student student : service.getStudents()){

            System.out.println("\nStudent Name: " + student.getName());

            if(student.getGrades().size() == 0){

                System.out.println("No grades recorded.");

            } 
            
            else{

                System.out.println("Grades: " + student.getGrades());
                System.out.println("Average: " + student.getAverage());
                System.out.println("Highest Grade: " + student.getHighest());
                System.out.println("Lowest Grade: " + student.getLowest());
            }

            System.out.println("------------------------------------");
        }

        if(service.getTotalGradeCount() > 0){

            System.out.println("\n===== CLASS STATISTICS =====");

            System.out.println("Total Students: " + service.getStudents().size());

            System.out.println("Total Grades Recorded: " + service.getTotalGradeCount());

            System.out.println("Class Average: " + service.getClassAverage());

            System.out.println("Highest Grade: " + service.getClassHighest());

            System.out.println("Lowest Grade: " + service.getClassLowest());
        }
    }
}