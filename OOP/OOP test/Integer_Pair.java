import java.util.*;

public class Integer_Pair{
    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        
        int terminate = 0;
        int number;
        
        //program will add the user's inputs to the arraylist
        //until the user will type 0
        do{
            number = scan.nextInt();
            inputs.add(number);
            
        }
        while (number != terminate);

        //calls the removeElements method
        removeElements(inputs);

        //prints the final list after complying to the requirements of the problem
        System.out.println("Final List: " );
        for (int i = 0; i < inputs.size(); i++){
            int element = inputs.get(i);
            System.out.println(element);
        }

        scan.close();
    }

    public static void removeElements(ArrayList<Integer> user_inputs){
        
        for (int i = 0; i < user_inputs.size() - 1; i++){
            if (user_inputs.get(i) > user_inputs.get(i + 1)){
                user_inputs.remove(i); //the left element
                user_inputs.remove(i + 1); //the right element
                i = i - 2; //2 will be subtracted from i (index) because 2 elements we removed
                
                //in cases wherein the user only has 2 elements
                //if this was the case, the i would be 1 - 2, resulting to a negative number
                //this if statement is created to prevent that from happening
                if (i < 0){
                    i = 0;
                }
            }
        }

        //to check whether the user's number of input is even or odd
        if (user_inputs.size() % 2 != 0){
            user_inputs.remove(user_inputs.size() - 1);
        }
    }
}