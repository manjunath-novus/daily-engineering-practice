
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            count += prefixCount.getOrDefault(
                prefixSum - goal, 0
            );

            prefixCount.put(
                prefixSum,
                prefixCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums1, 2));

        int[] nums2 = {0, 0, 0, 0, 0};
        System.out.println(numSubarraysWithSum(nums2, 0));

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(numSubarraysWithSum(nums3, 2));
    }
}
