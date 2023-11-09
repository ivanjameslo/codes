import java.util.InputMismatchException;
import java.util.Scanner;

public class Lo_Date {
    public static void main(String[] args) throws InvalidYearInput, InvalidMonthInput, InvalidDayInput{
        Scanner scan = new Scanner (System.in);

        int year = 0, month = 0, day = 0;

        try{
            year = scan.nextInt();
            if (year < 0){
                throw new InvalidYearInput("Invalid year input");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid year input");
            return;
        }

        //--------------------

        try {
            month = scan.nextInt();
            if (month < 1 || month > 12){
                throw new InvalidMonthInput("Invalid number of months");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid month input");
            return;
        }

        catch (InvalidMonthInput e){
            System.out.println(e.getMessage());
            return;
        }

        //--------------------

        try{
            day = scan.nextInt();
            if (day < 1 || day > 31){
                throw new InvalidDayInput("Invalid number of days");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid day input");
            return;
        }

        catch (InvalidDayInput e){
            System.out.println(e.getMessage());
            return;
        }

        //--------------------

        try {
            printDate(year, month, day);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
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
            System.out.println("Invalid number of days");
        }
        else{
            System.out.println(monthName[month - 1] + " " + day + ", " + year);
            System.out.println(numOfDaysInMonth + " days");
            if (numOfDaysInMonth == 29){
                System.out.println(year + " is a Leap Year");
            }
            else if (numOfDaysInMonth == 28){
                System.out.println(year + " is not a Leap Year");
            }
            else {
                System.out.println(year + " is a Common Year");
            }
            
        }
    }

    public static class InvalidYearInput extends Exception{
        public InvalidYearInput(String message){
            super(message);
        }
    }

    public static class InvalidMonthInput extends Exception{
        public InvalidMonthInput(String message){
            super(message);
        }
    }

    public static class InvalidDayInput extends Exception{
        public InvalidDayInput(String message){
            super(message);
        }
    }
}