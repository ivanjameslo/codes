import java.util.*;

public class LinkedList {
    public static void main(String[] args){
        IntSLList LL = new IntSLList();
        Scanner scan = new Scanner(System.in);

        int userInput;

        while(true){
            System.out.println("Enter integers: ");
            userInput = scan.nextInt();

            if (userInput == 0){
                break;
            }

            else if (userInput % 2 == 0){
                LL.addToTail(userInput);
            }

            else{
                LL.addToHead(userInput);
            }
        }

        LL.printAll();
        scan.close();
    }
}
