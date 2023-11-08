import java.util.*;
import java.io.*;

public class BSTMain {
    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("bst.txt");
        Scanner scan = new Scanner(fr);

        Scanner input = new Scanner(System.in);

        BST bst = new BST();
        int x;
        int num;

        while (scan.hasNextLine()) {
            x = scan.nextInt();
            bst.insert(x);
        }
        scan.close();

        System.out.print("Input a number: ");
        num = input.nextInt();

        if (bst.search(num) == null) {
            System.out.println("The number " + num + " is NOT found after checking " + bst.count() + " nodes.");
        } else if (num == bst.search(num).key) {
            System.out.println("The number " + num + " is found after checking " + bst.count() + " node/s.");
        }

        input.close();
    }
}
