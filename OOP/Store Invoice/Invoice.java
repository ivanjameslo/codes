public class Invoice {

    private String number;
    private String description;
    private int quantity;
    private double price;

    public Invoice() {
        this.number = "";
        this.description = "";
        this.quantity = 0;
        this.price = 0.00;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInvoice(int quantity, double price) {

        double invoiceAmount = 0.00;

        if (quantity < 0 || price < 0) {
            if (quantity < 0) {
                quantity = 0;
            }
            if (price < 0) {
                price = 0;
            }
            invoiceAmount = quantity * price;
        }

        else {
            invoiceAmount = quantity * price;
        }

        return invoiceAmount;
    }

}