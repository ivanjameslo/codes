import java.util.*;

public class Abbreviation{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String userInput;

        while(true){
            
            System.out.print("Enter a word to abbreviate (or 'EXIT' to quit): ");
            userInput = scan.nextLine();

            if (userInput.equalsIgnoreCase("EXIT")){
                break;
            }
            
            char[] string = userInput.toCharArray();
            char[] abbrev = new char[3];

            abbreviate(string, abbrev);
            String abbreviation = new String (abbrev);
            
            System.out.println(abbreviation + ".");
        }

        scan.close();
    }

    public static void abbreviate(char[] string, char[] abbrev){
        
        abbrev[0] = string[0];

        if(isConsonant(string[1])){
            abbrev[1] = string[1];
            abbrev[2] = string[string.length - 1];
        }
        else{
            abbrev[1] = string[string.length - 1];
        }
    }

    public static boolean isConsonant(char letter){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < vowels.length; i++){
            if (letter == vowels[i]){
                return false;
            }
        }

        return true;
    }
}