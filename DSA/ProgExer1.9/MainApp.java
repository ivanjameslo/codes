import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MainApp {
    
    private static Scanner scan = new Scanner(System.in);
    private static BST SRecordsTree = new BST();
    private static Software softwareRecords;

    public static void main(String[] args) throws Exception{
        boolean selection = true;
        int userChoice;

        readTextFile();

        while(selection){
            System.out.println("+------------------------------------------+");
            System.out.println("|          Select from the choices         |");
            System.out.println("| 1. Show Software                         |");
            System.out.println("| 2. Add Software                          |");
            System.out.println("| 3. Sell Software                         |");
            System.out.println("| 4. Exit and Save                         |");
            System.out.println("+------------------------------------------+");
            System.out.print("ENTER CHOICE: ");
            userChoice = scan.nextInt();
            scan.nextLine();

            switch (userChoice){
                case 1:
                    displayDetails();
                    break;
                case 2:
                    addSoftware();
                    break;
                case 3:
                    sellSoftware();
                    break;
                case 4:
                    exitAndSave();
                    selection = false;
                    break;
            }
        }
        scan.close();
    }

    public static void readTextFile(){
        String softwareName;
        String softwareVersion;
        int quantity;
        double price;

        try{
            FileReader file = new FileReader("software.txt");
            Scanner input = new Scanner(file);

            while(input.hasNextLine()){
                softwareName = input.nextLine();
                softwareVersion = input.nextLine();
                quantity = Integer.parseInt(input.nextLine());
                price = Double.parseDouble(input.nextLine());

                softwareRecords = new Software(softwareName, softwareVersion, quantity, price);
                SRecordsTree.insert(softwareRecords);
            }

            input.close();
        }
        catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateTextFile(){
        try{
            File softwareFile = new File("software.txt");
            FileWriter fileWriter = new FileWriter(softwareFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            SRecordsTree.inorderPrint(printWriter);

            printWriter.close();
        }
        catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void displayDetails(){
        System.out.println();
        System.out.printf(String.format("%-30s %-10s %-10s %-10s \n", "SOFTWARE", "VERSION", "QUANTITY", "PRICE"));
        SRecordsTree.inorder();
        System.out.println();
    }

    public static void addSoftware(){
        String softwareName;
        String softwareVersion;
        int quantity;
        double price;  

        System.out.println();
        System.out.print("Enter Software Name: ");
        softwareName = scan.nextLine();
        System.out.print("Enter Version: ");
        softwareVersion = scan.nextLine();
        System.out.print("Enter Quantity: ");
        quantity = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Price: ");
        price = scan.nextDouble();

        softwareRecords = new Software(softwareName, softwareVersion, quantity, price);
        SRecordsTree.insert(softwareRecords);

        System.out.println("Software added successfully!");
        System.out.println();
    }

    public static void sellSoftware(){
        String softwareName;
        int quantity;
        
        System.out.println();
        System.out.print("Enter the name of the Software you want to buy: ");
        softwareName = scan.nextLine();

        if(SRecordsTree.search(softwareName)){
            System.out.print("Enter the quantity you want to buy: ");
            quantity = scan.nextInt();
            scan.nextLine();

            if (quantity > softwareRecords.getQuantity()){
                System.out.println("Not enough stocks!");
            }
            else if (quantity < softwareRecords.getQuantity()){
                softwareRecords.setQuantity(softwareRecords.getQuantity() - quantity);
                SRecordsTree.selected(softwareName, quantity);
                System.out.println("Software bought successfully!");
            }

            else if (quantity == softwareRecords.getQuantity()){
                softwareRecords.setQuantity(softwareRecords.getQuantity() - quantity);
                SRecordsTree.selected(softwareName, quantity);
                System.out.println("Software bought successfully!");
                SRecordsTree.deleteByMerging(softwareRecords);
            }
            else{
                System.out.println("Invalid quantity input!");
            }
        }
        else{
            System.out.println("Software not found!");
        }
        System.out.println();
     }

     public static void exitAndSave(){
        System.out.print("\033c");
        System.out.println("Here's your final list of software:");
        displayDetails();
        System.out.println("Thank you for using the program!");
        updateTextFile();
     }
}