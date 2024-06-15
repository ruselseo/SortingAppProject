import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SortingAppTest {

    private final String[] args;
    private final String expectedOutput;

    // Redirect stdout to capture console output
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public SortingAppTest(String[] args, String expectedOutput) {
        this.args = args;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"5", "3", "8", "6", "2"}, "Sorted numbers:\n2\n3\n5\n6\n8\n"},
                {new String[]{"5"}, "Sorted numbers:\n5\n"},
                {new String[]{}, "No arguments provided.\n"},
                {new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, "Sorted numbers:\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n"},
                {new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}, "Too many arguments provided. Maximum is 10.\n"}
        });
    }

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