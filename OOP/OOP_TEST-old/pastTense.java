import java.util.*;

public class pastTense {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word;

        do{
            word = scan.nextLine();
            char lastLetter = word.charAt(word.length() - 1);

            if (word.equals("EXIT")){
                break;
            }

            if (lastLetter == 'e') {
                System.out.println(word + "d");
            }

            else if (lastLetter == 'y'){
                char preceded = word.charAt(word.length() - 2);
                if (isConsonant(preceded)){
                    System.out.println(word.substring(0, word.length() - 1) + "ied");
                }
                else {
                    System.out.println(word + "ed");
                }
            }

            else if (word.length() >= 3 && 
                isConsonant(word.charAt(word.length() - 3)) && 
                !isConsonant(word.charAt(word.length() - 2)) &&
                isConsonant(word.charAt(word.length() - 1)) &&
                word.charAt(word.length() - 1) != 'x' &&
                word.charAt(word.length() - 1) != 'y' &&
                word.charAt(word.length() - 1) != 'z'){
                    System.out.println(word + word.charAt(word.length() - 1) + "ed");
            }

            else{
                System.out.println(word + "ed");
            }
            
        } while (!word.equals("EXIT"));

        scan.close();
    }

    public static boolean isConsonant(char last){
        return "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(last) != -1;
    }

}