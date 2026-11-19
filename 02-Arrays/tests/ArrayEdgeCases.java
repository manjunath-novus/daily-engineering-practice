
import java.util.*;

public class ArrayEdgeCases {

    private static int passed = 0;
    private static int failed = 0;

    private static void check(String name, boolean condition) {
        if (condition) {
            System.out.println("PASS: " + name);
            passed++;
        } else {
            System.out.println("FAIL: " + name);
            failed++;
        }
    }

    private static boolean containsTriplet(
            List<List<Integer>> result, List<Integer> expected) {
        return result.contains(expected);
    }

    private static void testTwoSum() {
        System.out.println("\n--- Two Sum Tests ---");

        check("Normal pair",
            Arrays.equals(TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9),
                          new int[]{0, 1}));

        check("No valid pair",
            Arrays.equals(TwoSum.twoSum(new int[]{1, 2, 3}, 10),
                          new int[]{-1, -1}));

        check("Duplicate numbers",
            Arrays.equals(TwoSum.twoSum(new int[]{3, 3}, 6),
                          new int[]{0, 1}));

        check("Negative numbers",
            Arrays.equals(TwoSum.twoSum(new int[]{-3, 4, 3, 90}, 0),
                          new int[]{0, 2}));

        check("Empty input",
            Arrays.equals(TwoSum.twoSum(new int[]{}, 5),
                          new int[]{-1, -1}));

        check("Single element",
            Arrays.equals(TwoSum.twoSum(new int[]{5}, 10),
                          new int[]{-1, -1}));
    }

    private static void testThreeSum() {
        System.out.println("\n--- Three Sum Tests ---");

        List<List<Integer>> normal =
            ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        check("Normal triplets",
            normal.size() == 2 &&
            containsTriplet(normal, Arrays.asList(-1, -1, 2)) &&
            containsTriplet(normal, Arrays.asList(-1, 0, 1)));

        check("No valid triplets",
            ThreeSum.threeSum(new int[]{1, 2, 3}).isEmpty());

        List<List<Integer>> duplicates =
            ThreeSum.threeSum(new int[]{0, 0, 0, 0});

        check("Duplicate values produce one triplet",
            duplicates.size() == 1 &&
            containsTriplet(duplicates, Arrays.asList(0, 0, 0)));

        List<List<Integer>> negatives =
            ThreeSum.threeSum(new int[]{-2, 0, 1, 1, 2});

        check("Negative and positive values",
            containsTriplet(negatives, Arrays.asList(-2, 0, 2)) &&
            containsTriplet(negatives, Arrays.asList(-2, 1, 1)));

        check("Fewer than three elements",
            ThreeSum.threeSum(new int[]{1, 2}).isEmpty());

        check("Null input",
            ThreeSum.threeSum(null).isEmpty());

        int[] original = {3, -1, -2, 0};
        int[] copy = original.clone();
        ThreeSum.threeSum(original);

        check("Original input remains unchanged",
            Arrays.equals(original, copy));

        check("Negative integer overflow",
            ThreeSum.threeSum(
                new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 0}
            ).isEmpty());

        check("Positive integer overflow",
            ThreeSum.threeSum(
                new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 2}
            ).isEmpty());

        check("Valid triplet with integer extremes",
            containsTriplet(
                ThreeSum.threeSum(
                    new int[]{Integer.MIN_VALUE, 1, Integer.MAX_VALUE}
                ),
                Arrays.asList(
                    Integer.MIN_VALUE, 1, Integer.MAX_VALUE
                )
            ));
    }

    public static void main(String[] args) {
        testTwoSum();
        testThreeSum();

        System.out.println("\n========================");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("========================");

        if (failed > 0) {
            throw new AssertionError("Some tests failed!");
        }
    }
}
