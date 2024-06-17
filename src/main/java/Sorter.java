import java.util.Arrays;

public class Sorter {
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        }
        if (args.length > 10) {
            System.out.println("Too many arguments provided. Maximum is 10.");
            return;
        }

        int[] numbers = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + args[i]);
                return;
            }
        }

        numbers = Arrays.stream(numbers).sorted().toArray();

        // Print sorted numbers
        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}