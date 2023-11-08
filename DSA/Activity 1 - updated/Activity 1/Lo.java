import java.util.*;
import java.util.Random;

public class Lo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int minimum;
        int maximum;
        int attempts = 1;

        System.out.println("Set the range of numbers you want to guess.");
        System.out.print("Minimum: ");
        minimum = scan.nextInt();
        System.out.print("Maximum: ");
        maximum = scan.nextInt();

        // to start the randomizer at minimum and end at maximum
        int int_random = rand.nextInt(maximum - minimum) + minimum;

        System.out.println("------------------------------------");
        System.out.println("Attempt #: " + attempts);
        System.out.println("Guess a number from " + minimum + " to " + maximum);
        int user_guess = scan.nextInt();

        while (user_guess != int_random) {

            // if the user's guess is higher than the randomized number
            if (user_guess > int_random) {
                System.out.println("Lower!"); // tells the user to guess a lower number
                System.out.println("------------------------------------");
                attempts = attempts + 1;
                System.out.println("Attempt #: " + attempts);
                System.out.println("Guess again (" + minimum + " to " + maximum + "):");
                user_guess = scan.nextInt();
            }

            // if the user's guess is lower than the randomized number
            if (user_guess < int_random) {
                System.out.println("Higher!"); // tells the user to guess a higher number
                System.out.println("------------------------------------");
                attempts = attempts + 1;
                System.out.println("Attempt #: " + attempts);
                System.out.println("Guess again (" + minimum + " to " + maximum + "):");
                user_guess = scan.nextInt();
            }
        }

        // if the user guessed the correct number
        if (user_guess == int_random) {
            System.out.println("You have guessed the correct number!");
            System.out.println("------------------------------------");
            System.out.println("Total number of attempts: " + attempts);
        }

        scan.close();
    }
}