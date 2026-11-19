
import java.util.*;

public class ThreeSumOverflowTest {

    public static void main(String[] args) {

        // Test 1: Integer boundary values
        int[] test1 = {
            Integer.MAX_VALUE,
            1,
            Integer.MIN_VALUE
        };

        List<List<Integer>> result1 = ThreeSum.threeSum(test1);

        System.out.println("Test 1: " + result1);

        if (!result1.equals(
                Arrays.asList(
                    Arrays.asList(
                        Integer.MIN_VALUE,
                        1,
                        Integer.MAX_VALUE
                    )
                ))) {
            throw new AssertionError("Test 1 FAILED");
        }

        System.out.println("Test 1 PASSED\n");


        // Test 2: Another integer boundary case
        int[] test2 = {
            Integer.MIN_VALUE,
            1,
            Integer.MAX_VALUE
        };

        List<List<Integer>> result2 = ThreeSum.threeSum(test2);

        System.out.println("Test 2: " + result2);

        if (!result2.equals(
                Arrays.asList(
                    Arrays.asList(
                        Integer.MIN_VALUE,
                        1,
                        Integer.MAX_VALUE
                    )
                ))) {
            throw new AssertionError("Test 2 FAILED");
        }

        System.out.println("Test 2 PASSED\n");


        // Test 3: Standard Three Sum example
        int[] test3 = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result3 = ThreeSum.threeSum(test3);

        System.out.println("Test 3: " + result3);

        List<List<Integer>> expected3 = Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        );

        if (!result3.equals(expected3)) {
            throw new AssertionError("Test 3 FAILED");
        }

        System.out.println("Test 3 PASSED\n");


        // Test 4: Detect integer overflow false positive
        int[] test4 = {
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            2
        };

        List<List<Integer>> result4 = ThreeSum.threeSum(test4);

        System.out.println("Test 4: " + result4);

        if (!result4.isEmpty()) {
            throw new AssertionError(
                "Test 4 FAILED: Expected an empty list"
            );
        }

        System.out.println("Test 4 PASSED\n");


        System.out.println("ALL 4 TESTS PASSED SUCCESSFULLY!");
    }
}
