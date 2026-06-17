import java.util.ArrayList;

public class GradeTrackerService {

    private ArrayList<Student>students;

    public GradeTrackerService(){
        students = new ArrayList<>();
    }

    public ArrayList<Student>getStudents(){
        return students;
    }

    public boolean addStudent(String name){

        if(name == null || name.trim().isEmpty()){
            return false;
        }

        for(Student s : students){

            if(s.getName().equalsIgnoreCase(name)){
                return false;
            }
        }

        students.add(new Student(name));
        return true;
    }

    public boolean addGrade(int studentIndex, double grade){

        if(studentIndex < 0 || studentIndex >= students.size()){
            return false;
        }

        if (grade < 0 || grade > 100){
            return false;
        }

        students.get(studentIndex).addGrade(grade);
        return true;
    }

    public double getClassAverage(){

        double sum=0;
        int totalGrades=0;

        for (Student s : students){

            ArrayList<Double>grades=s.getGrades();

            for (double grade : grades){
                sum += grade;
                totalGrades++;
            }
        }

        if(totalGrades == 0){
            return 0;
        }

        return sum/totalGrades;
    }

    public double getClassHighest(){

        double highest = 0;

        for(Student s : students){

            ArrayList<Double> grades = s.getGrades();

            for(double grade : grades){

                if(grade > highest){
                    highest = grade;
                }
            }
        }

        return highest;
    }

    public double getClassLowest(){

        double lowest = 100;

        for(Student s : students){

            ArrayList<Double> grades = s.getGrades();

            for(double grade : grades){
                if(grade < lowest){
                    lowest = grade;
                }
            }
        }

        return lowest;
    }

    public int getTotalGradeCount(){

        int count = 0;

        for(Student s : students){
            count += s.getGrades().size();
        }

        return count;
    }
}