import java.util.ArrayList;
import java.util.Scanner;

public class gpt {
    public static void removePairs(ArrayList<Integer> list) {
        int i = 0;
        while (i < list.size() - 1) {
            if (list.get(i) > list.get(i + 1)) {
                list.remove(i);
                list.remove(i);  // After removing the current element, the next element takes its place
                i = Math.max(i - 1, 0);  // Move back one step to check the previous element again
            } else {
                i++;
            }
        }

        if (list.size() % 2 != 0) {
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer (or 0 to terminate): ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            numbers.add(num);
        }

        removePairs(numbers);

        System.out.println("Resulting list: " + numbers);
    }
}
