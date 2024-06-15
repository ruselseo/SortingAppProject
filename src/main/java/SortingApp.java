
import java.util.Arrays;
/**
 * SortingAppTest is a JUnit test class for testing the functionality of SortingApp.
 * It uses parameterized tests to cover various scenarios and edge cases.
 * <p>
 * The test cases include:
 * <ul>
 * <li>Sorting an array of integers with multiple elements.</li>
 * <li>Sorting an array with a single element.</li>
 * <li>Handling cases with no arguments provided.</li>
 * <li>Handling cases with more than ten arguments provided.</li>
 * </ul>
 * </p>
 * <p>
 * Each test case captures the output of SortingApp.main() and compares it against
 * expected output strings to verify correctness.
 * </p>
 * <p>
 * Note: The expected output strings use the system's line separator (\n or \r\n)
 * depending on the platform.
 * </p>
 *
 * @author Ruslan Ibragimov
 * @version 1.0
 * @since 2024-06-16
 */
public class SortingApp {
    /**
     * Entry point of the SortingApp application.
     * <p>
     * Parses command-line arguments to integers, sorts them in ascending order,
     * and prints them to standard output.
     * </p>
     * <p>
     * Handles invalid input scenarios gracefully:
     * <ul>
     * <li>If no arguments are provided, prints "No arguments provided."</li>
     * <li>If more than ten arguments are provided, prints "Too many arguments provided.
     * Maximum is 10."</li>
     * <li>If any argument cannot be parsed as an integer, prints "Invalid number format:
     * &lt;arg&gt;" and stops further processing.</li>
     * </ul>
     * </p>
     *
     * @param args Command-line arguments containing integer values to be sorted.
     */
    public static void main(String[] args) {
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

        // Sort the array
        Arrays.sort(numbers);

        // Print sorted numbers
        System.out.println("Sorted numbers:");
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
