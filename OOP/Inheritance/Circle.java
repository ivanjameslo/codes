public class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double radius() {
        return this.radius;
    }

    public double diameter() {
        return this.radius * 2;
    }

    public double area() {
        return 3.14 * (this.radius * this.radius);
    }

    public double circumference() {
        return 2 * 3.14 * this.radius;
    }

    public void toPrint() {
        System.out.println("Diameter: " + String.format("%.2f", diameter()));
        System.out.println("Area: " + String.format("%.2f", area()));
        System.out.println("Circumference: " + String.format("%.2f", circumference()));
    }
}
