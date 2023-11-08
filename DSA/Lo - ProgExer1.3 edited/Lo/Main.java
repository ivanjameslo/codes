import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        
        FileReader fr = new FileReader("student.txt");
        Scanner scan = new Scanner(fr);

        String studentID;
        String lastName;
        String firstName;
        char gender;
        String course;
        int yearLevel;

        ArrayList<Student> list = new ArrayList<Student>();
        

        while(scan.hasNext()){
            
            studentID = scan.nextLine();
            lastName = scan.nextLine();
            firstName = scan.nextLine();
            gender = scan.nextLine().charAt(0);
            course = scan.nextLine();
            yearLevel = Integer.parseInt(scan.nextLine());

            list.add(new Student(lastName, firstName, studentID, course, gender, yearLevel));
        }

        StudentCompareCourse temp = new StudentCompareCourse();
        list.sort(temp);

        for(Student studentList : list){
            studentList.display();
        }

        scan.close();
    }
}