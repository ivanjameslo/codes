import java.util.*;

public class InvoiceTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number;
        String description;
        int quantity;
        double price;

        Invoice input = new Invoice();

        System.out.println("Enter the part-number: ");
        number = scan.nextLine();
        input.setNumber(number);

        System.out.println("Enter the description: ");
        description = scan.nextLine();
        input.setDescription(description);

        System.out.println("Enter the quantity: ");
        quantity = scan.nextInt();
        input.setQuantity(quantity);

        System.out.println("Enter the price: ");
        price = scan.nextDouble();
        input.setPrice(price);

        System.out.println("Invoice amount is: " + String.format("%.2f", input.getInvoice(quantity, price)));

        scan.close();
    }
}
