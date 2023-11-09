import java.util.Scanner;
public class date{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int year, month, day;

        try{
            year = scan.nextInt();
            month = scan.nextInt();
            day = scan.nextInt();
            printDate(year, month, day);
        }
        catch(Exception e){
            System.out.println("Invalid date");
        }

        scan.close();
    }


    public static void printDate(int year, int month, int day){
        
        int numOfDaysInMonth = 0;
        String monthName[] = {"January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "Decemeber"};

        //num of days in month
        if (month == 4 || month == 6 || month == 9 || month == 11){
            numOfDaysInMonth = 30;
        }
        else if (month == 2){ //check if feb is a leap year
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                numOfDaysInMonth = 29;
            }
            else {
                numOfDaysInMonth = 28;
            }
        }
        else{
            numOfDaysInMonth = 31;
        }

        //print lines
        if (month < 1 || month > 12 || day < 1 || day > numOfDaysInMonth){
            System.out.println("Invalid date");
        }
        else{
            System.out.println(monthName[month - 1] + " " + day + ", " + year);
            System.out.println(numOfDaysInMonth + " days");
            if (numOfDaysInMonth == 29){
                System.out.println(year + " is a Leap Year");
            }
            else {
                System.out.println(year + " is not a Leap Year");
            }
            
        }
    }
}