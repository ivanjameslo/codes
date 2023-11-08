public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    public String toString() {
        return "Length: " + length + "\nWidth: " + width + "\n" + super.toString();
    }

    public int getArea() {
        return length * width;
    }
}