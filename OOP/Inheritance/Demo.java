import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userChoice;
        int userRadius;
        int userHeight;
        boolean selection = true;
        Circle c;

        while (selection) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("|                        Pick an Option                           |");
            System.out.println("|1. Compute for Circle                                            |");
            System.out.println("|2. Compute for Cylinder                                          |");
            System.out.println("|3. EXIT                                                          |");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("User choice: ");
            userChoice = scan.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter a radius: ");
                    userRadius = scan.nextInt();
                    c = new Circle(userRadius);
                    c.toPrint();
                    break;

                case 2:
                    System.out.print("Enter a radius: ");
                    userRadius = scan.nextInt();
                    System.out.print("Enter a height: ");
                    userHeight = scan.nextInt();
                    c = new Cylinder(userRadius, userHeight);
                    c.toPrint();
                    break;

                case 3:
                    selection = false;
            }

        }
        scan.close();
    }
}
