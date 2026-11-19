
import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        int[] arr = nums.clone();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                // Use long to prevent integer overflow
                    long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    result.add(Arrays.asList(
                        arr[i], arr[left], arr[right]
                    ));

                    left++;
                    right--;

                    // Skip duplicate values
                    while (left < right &&
                           arr[left] == arr[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           arr[right] == arr[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(nums));
    }
}
