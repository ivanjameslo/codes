import java.util.*;

public class integer_pair {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        int terminate = 0;
        int number;

        do {
            number = scan.nextInt();
            inputs.add(number);
        } while (number != terminate);

        removeAndAddElements(inputs);

        scan.close();
    }

    public static void removeAndAddElements(ArrayList<Integer> userInputs) {

        if (userInputs.size() % 2 != 0) {
            userInputs.remove(userInputs.size() - 1);
        }

        for (int i = 0; i < userInputs.size(); i = i + 2) {

            if (userInputs.get(i) < userInputs.get(i + 1)) {
                System.out.println(userInputs.get(i));
                System.out.println(userInputs.get(i + 1));
            }

        }
    }
}