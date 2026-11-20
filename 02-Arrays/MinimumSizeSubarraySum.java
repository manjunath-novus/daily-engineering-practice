
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLength = Math.min(
                    minLength,
                    right - left + 1
                );

                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums1));

        int[] nums2 = {1, 4, 4};
        System.out.println(minSubArrayLen(4, nums2));

        int[] nums3 = {1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(11, nums3));
    }
}
