import java.util.*;


public class Student {

    private String name;
    private ArrayList<Double>grades;

    public Student(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
     public void addGrade(double grade){
        grades.add(grade);
    }

    public ArrayList<Double>getGrades(){
        return grades;
    }

    public double getAverage(){
        
        if (grades.isEmpty())return 0.0;
        
        double sum = 0;
        
        for (double g : grades)sum += g;
        
        return sum/grades.size();
    }

    public double getHighest(){
        
        if (grades.isEmpty())return Double.NaN;
        double max = Double.NEGATIVE_INFINITY;
        
        for (double g : grades){
            
            if (g > max) max = g;
        }
        
        return max;
    }

    public double getLowest(){
        
        if(grades.isEmpty())return Double.NaN;
        
        double min = Double.POSITIVE_INFINITY;
        for (double g : grades){
            
            if (g < min) min = g;
        }
        
        return min;
    }
    
    
    
    @Override
    public String toString() {
        
        return "Name: " + name + "\nGrades: " + grades + "\nAverage: " + getAverage();
        
    }

    
    
}
