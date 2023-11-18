import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainApp {
    
    private static Scanner scan = new Scanner(System.in);
    private static BST SRecordsTree = new BST();
    private static Software softwareRecords;

    public static void main(String[] args){
        boolean selection = true;
        int userChoice;

        readTextFile();

        while(selection){
            System.out.println("+------------------------------------------+");
            System.out.println("|          Select from the choices         |");
            System.out.println("| 1. Show Software                         |");
            System.out.println("| 2. Add Software                          |");
            System.out.println("| 3. Sell Software                         |");
            System.out.println("| 4. Exit                                  |");
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
                    System.out.print("\033c");
                    System.out.println("Here's your final list of software:");
                    displayDetails();
                    System.out.println("Thank you for using the program!");
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
            FileWriter file = new FileWriter("software.txt", true);
            PrintWriter writes = new PrintWriter(file);
            writes.println(softwareRecords.getSoftwareName());
            writes.println(softwareRecords.getSoftwareVersion());
            writes.println(softwareRecords.getQuantity());
            writes.println(softwareRecords.getPrice());

            writes.close();
        }
        catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteLinesInTextFile(){
        String lineToRemove1 = softwareRecords.getSoftwareName();
        String lineToRemove2 = softwareRecords.getSoftwareVersion();
        String lineToRemove3 = Integer.toString(softwareRecords.getQuantity());
        String lineToRemove4 = Double.toString(softwareRecords.getPrice());

        String originalFile = "software.txt";
        String destinationFile = "temp.txt";
        String currentLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile));

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.equals(lineToRemove1)) {
                    continue;
                }
                if (currentLine.equals(lineToRemove2)){
                    continue;
                }
                if (currentLine.equals(lineToRemove3)){
                    continue;
                }
                if (currentLine.equals(lineToRemove4)){
                    continue;
                }
                bw.write(currentLine + System.getProperty("line.separator"));
            }
            br.close();
            bw.close();
        }
        catch(Exception e){}
        copyBack();
    }

    public static void copyBack(){
        String tempFile = "temp.txt";
        String originalFile = "software.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(originalFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            System.out.println("Content copied back to software.txt successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSoftwareRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader("software.txt"))) {
            String softwareName;
            String softwareVersion;
            int quantity;
            double price;
    
            while ((softwareName = reader.readLine()) != null
                    && (softwareVersion = reader.readLine()) != null
                    && (quantity = Integer.parseInt(reader.readLine())) != 0
                    && (price = Double.parseDouble(reader.readLine())) != 0) {
                Software softwareRecords = new Software(softwareName, softwareVersion, quantity, price);
                SRecordsTree.insert(softwareRecords);
            }
        } catch (IOException e) {
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

        updateTextFile();

        System.out.println("Software added successfully!");
        System.out.println();
    }

    public static void sellSoftware(){
        String softwareName;
        String softwareVersion;
        int quantity;

        loadSoftwareRecords();
        
        System.out.println();
        System.out.print("Enter the name of the Software you want to buy: ");
        softwareName = scan.nextLine();

        if(SRecordsTree.searchName(softwareName)){
            System.out.print("Enter the version: ");
            softwareVersion = scan.nextLine();

            if(SRecordsTree.searchVersion(softwareVersion)){
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
                    deleteLinesInTextFile();
                    updateTextFile();
                }

                else if (quantity == softwareRecords.getQuantity()){
                    softwareRecords.setQuantity(softwareRecords.getQuantity() - quantity);
                    SRecordsTree.selected(softwareName, quantity);
                    System.out.println("Software bought successfully!");
                    SRecordsTree.deleteByMerging(softwareRecords);
                    deleteLinesInTextFile();
                    updateTextFile();
                }
                else{
                    System.out.println("Invalid quantity input!");
                }
            }
            else{
                System.out.println("Software Version not found!");
            }
        }
        else{
            System.out.println("Software Name not found!");
        }
        System.out.println();
    }
}