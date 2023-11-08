import java.util.*;

public class past_tense_vTwo {
    
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        String inputtedWord = scan.nextLine();

        while(true){
            if (inputtedWord.equals("EXIT")){
                break;
            }

            char[] word = inputtedWord.toCharArray();
            formPast(word);

            System.out.println(word);
        }

        scan.close();
    }

    public static void formPast(char[] word){
        int length;
        length = word.length;

        if (length >= 1 && word[length - 1] == 'e'){
            word[length - 1] = 'd';
        }
        else if(length >= 2 && word[length - 1] == 'y' && isConsonant(word[length - 2])){
            word[length - 1] = 'i';
            word[length] = 'e';
            word[length + 1] = 'd';
        }
        else if(length >= 2 && word[length -1] == 'y' && !isConsonant(word[length - 2])){
            word[length] = 'e';
            word[length + 1] = 'd';
        }
        else if(length >= 3 && 
        isConsonant(word[length - 3]) && 
        !isConsonant(word[length - 2]) &&
        isConsonant(word[length - 1]) &&
        word[length -1] != 'x' &&
        word[length - 1] != 'y' &&
        word[length - 1] != 'z'){
            char lastC = word[length - 1];
            word[length] = lastC;
            word[length + 1] = 'e';
            word[length + 2] = 'd'; 
        }
        else{
            word[length] = 'e';
            word[length + 1] = 'd';
        }
    }

    public static boolean isConsonant(char lastLetter){
        return "BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz".indexOf(lastLetter) != -1;
    }
}
