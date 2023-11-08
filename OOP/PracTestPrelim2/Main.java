import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Item> items = new ArrayList<Item>();
        String userInput;

        while(true){
                
            String item_name = scan.nextLine();
            int quantity = Integer.parseInt(scan.nextLine());
            double price = Double.parseDouble(scan.nextLine());

            items.add(new Item(item_name, quantity, price));

            userInput = scan.nextLine();

            if(userInput.equalsIgnoreCase("N")){
                break;
            }
        }

        double total = 0.00;

        for(Item x : items){
            System.out.println(x);
            total = total + x.cost();
        }

        System.out.println("Total amount in shopping cart: " + String.format("%.2f", total));

        scan.close();
    }
}