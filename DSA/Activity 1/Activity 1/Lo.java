import java.util.*;
import java.util.Random;

public class Lo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int minimum = 1;
        int maximum = 100;
        int int_random = rand.nextInt(maximum) + minimum;
        int attempts = 1;

        System.out.println("Guess a number from 1-100: ");
        int user_guess = scan.nextInt();

        while (user_guess != int_random) {
            if (user_guess > int_random) {
                System.out.println("Lower! Guess again:");
                user_guess = scan.nextInt();
                attempts = attempts + 1;
            }
            if (user_guess < int_random) {
                System.out.println("Higher! Guess again:");
                user_guess = scan.nextInt();
                attempts = attempts + 1;
            }
        }

        if (user_guess == int_random) {
            System.out.println("You have guessed the correct number!");
            System.out.println("Number of attempts: " + attempts);
        }

        scan.close();
    }
}