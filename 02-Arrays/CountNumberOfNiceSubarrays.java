
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {

        // Stores prefix odd counts and their frequencies
        Map<Integer, Integer> prefixCount = new HashMap<>();

        // An empty prefix has zero odd numbers
        prefixCount.put(0, 1);

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {

            // Increase count when the current number is odd
            if (num % 2 != 0) {
                oddCount++;
            }

            // Find how many earlier prefixes leave exactly k odd numbers
            int required = oddCount - k;

            result += prefixCount.getOrDefault(required, 0);

            // Store the frequency of the current prefix odd count
            prefixCount.put(
                oddCount,
                prefixCount.getOrDefault(oddCount, 0) + 1
            );
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;

        int[] nums2 = {2, 4, 6};
        int k2 = 1;

        int[] nums3 = {1, 2, 1, 2, 1};
        int k3 = 2;

        System.out.println(numberOfSubarrays(nums1, k1)); // 2
        System.out.println(numberOfSubarrays(nums2, k2)); // 0
        System.out.println(numberOfSubarrays(nums3, k3)); // 4
    }
}
