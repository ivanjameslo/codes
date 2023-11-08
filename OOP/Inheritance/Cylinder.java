public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double volume() {
        return area() * this.height;
    }

    public double surfaceArea() {
        return (circumference() * this.height) + (2 * area());
    }

    public void toPrint() {
        System.out.println("Diameter: " + String.format("%.2f", diameter()));
        System.out.println("Area: " + String.format("%.2f", area()));
        System.out.println("Circumference: " + String.format("%.2f", circumference()));
        System.out.println("Volume: " + String.format("%.2f", volume()));
        System.out.println("Surface Area: " + String.format("%.2f", surfaceArea()));
    }
}
