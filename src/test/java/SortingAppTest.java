import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
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
@RunWith(Parameterized.class)
public class SortingAppTest {

    private final String[] args;
    private final String expectedOutput;

    // Redirect stdout to capture console output
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Constructs a SortingAppTest with the specified command-line arguments and expected output.
     *
     * @param args           Command-line arguments to be tested.
     * @param expectedOutput Expected output of SortingApp for the given arguments.
     */
    public SortingAppTest(String[] args, String expectedOutput) {
        this.args = args;
        this.expectedOutput = expectedOutput;
    }

    /**
     * Provides data for parameterized tests. Each entry contains command-line arguments
     * and the corresponding expected output of SortingApp.
     *
     * @return Collection of argument-output pairs for parameterized testing.
     */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"5", "3", "8", "6", "2"}, "Sorted numbers:\r\n2\r\n3\r\n5\r\n6\r\n8\r\n"},
                {new String[]{"5"}, "Sorted numbers:\r\n5\r\n"},
                {new String[]{}, "No arguments provided.\r\n"},
                {new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, "Sorted numbers:\r\n1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n"},
                {new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}, "Too many arguments provided. Maximum is 10.\r\n"}
        });
    }

    /**
     * Test method for SortingApp.main() to verify sorting functionality and output.
     * Captures the console output of SortingApp and compares it against expectedOutput.
     */
    @Test
    public void testSortingApp() {
        // Redirect System.out to capture console output
        System.setOut(new PrintStream(outputStream));

        // Run SortingApp.main() with current args
        SortingApp.main(args);

        // Assert console output matches expectedOutput
        assertEquals(expectedOutput, outputStream.toString());

        // Restore System.out
        System.setOut(originalOut);
    }
}