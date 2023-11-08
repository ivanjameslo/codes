public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public String toString() {
        return "Base: " + String.format("%.2f", base) + "\nHeight: " + String.format("%.2f", height) + "\n"
                + super.toString();
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}