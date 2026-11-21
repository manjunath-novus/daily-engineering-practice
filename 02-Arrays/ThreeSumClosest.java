
import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        long closestSum = (long) nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) closestSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums1, 1));

        int[] nums2 = {0, 0, 0};
        System.out.println(threeSumClosest(nums2, 1));

        int[] nums3 = {1, 1, 1, 0};
        System.out.println(threeSumClosest(nums3, 100));
    }
}
