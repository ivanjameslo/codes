import java.util.*;

public class UseSubject {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String subjectCode;
        int creditUnits;

        Subject[] subjs = new Subject[10];

        for(int i = 0; i < subjs.length; i++){
            System.out.println("Enter Subject Code: ");
            subjectCode = scan.nextLine();
            System.out.println("Enter Credit Units: ");
            creditUnits = scan.nextInt();
            scan.nextLine();

            subjs[i] = new Subject(subjectCode, creditUnits);
        }

        System.out.printf("%-32s%-10s \n", "Subject Code", "Credit Units");

        for(int i = 0; i < subjs.length; i++){
            System.out.printf("%-32s%-10d \n", subjs[i].getSubjectCode(), subjs[i].getCreditUnits());
        }

        scan.close();
    }
}
