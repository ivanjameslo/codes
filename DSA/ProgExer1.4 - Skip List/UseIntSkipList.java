import java.io.*;
import java.util.*;

public class UseIntSkipList {
    public static void main (String[] args) throws EOFException, FileNotFoundException {

        Scanner inFile = new Scanner (new FileReader("data.txt"));
        Scanner scan = new Scanner(System.in);

        IntSkipList skipList = new IntSkipList();

        while (inFile.hasNextLine()) {
            int storedValues = Integer.parseInt(inFile.nextLine());
            skipList.skipListInsert(storedValues);
        }

        inFile.close();

        System.out.println("--------------------------------------------------");
        System.out.println("Inserted elements: ");
        skipList.printSkipList();
        System.out.println("--------------------------------------------------");

        
        System.out.print("Enter number you want to search: ");
        int userInput = scan.nextInt();

        int num = skipList.skipListSearch(userInput);

        if (num > 0) {
            System.out.println(userInput + " was found in the list after checking " + skipList.count + " nodes.");
        } else {
            System.out.println(userInput + " is not part of the list.");
        }

        scan.close();

    }
}
