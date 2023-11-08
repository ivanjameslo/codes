public class Main {
    public static void main(String[] args) {

        Shape s = new Shape("Green");
        getArea(s);
        s = new Rectangle("Blue", 20, 11);
        getArea(s);
        s = new Triangle("Red", 11.20, 10.10);
        getArea(s);

    }

    public static void getArea(Shape s) {
        if (s instanceof Triangle) {
            Triangle t = (Triangle) s;
            System.out.println("------------------------");
            System.out.println("TRIANGLE");
            System.out.println(t.toString());
            System.out.println("Area: " + String.format("%.2f", t.getArea()));
            System.out.println("------------------------");
        } else if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            System.out.println("------------------------");
            System.out.println("RECTANGLE");
            System.out.println(r.toString());
            System.out.println("Area: " + r.getArea());
            System.out.println("------------------------");
        } else {
            System.out.println("------------------------");
            System.out.println("Invalid Shape.");
            System.out.println("------------------------");
        }
    }
}