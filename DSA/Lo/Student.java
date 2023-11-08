import java.util.Comparator;

public class Student {
    private String lastname, firstname, studentid, course;
    private char gender;
    private int yearlevel;    
    
    public Student(String ln, String fn, String id, String cors, char g, int yl) {
    	lastname = ln;
    	firstname = fn;
    	studentid = id;
    	course = cors;
    	gender = g;
    	yearlevel = yl;
    }

    public int compareTo(Object anotherObject){
        Student anotherStudent = (Student) anotherObject;
        return this.course.compareTo(anotherStudent.course);
    }
    
    public void display() {    	
        System.out.printf("ID: %-8s  Name: %-20s  Sex: %c  Course: %-8s  Year: %d\n", studentid, (lastname + ", " + firstname), gender, course, yearlevel );
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
    public char getGender(){
        return gender;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setStudentId(String studentid){
        this.studentid = studentid;
    }
    
    public String getStudentId(){
        return studentid;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public String getCourse(){
        return course;
    }
    
    public void setYearLevel(int yearlevel){
        this.yearlevel = yearlevel;
    }
    
    public int getYearLevel(){
        return yearlevel;
    }
}

class StudentCompareCourse implements Comparator<Student>{

    public int compare(Student a, Student b){
        
        int course_order = a.getCourse().compareTo(b.getCourse()),
            lastName_order = a.getLastname().compareTo(b.getLastname()),
            firstName_order = a.getFirstname().compareTo(b.getLastname());

        if (course_order != 0){
            return course_order;
        }
        else if (lastName_order != 0){
            return lastName_order;
        }
        else{
            return firstName_order;
        }
    }
}