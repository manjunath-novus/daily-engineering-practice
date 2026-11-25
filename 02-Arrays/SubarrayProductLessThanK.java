
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 5, 2, 6};
        System.out.println(numSubarrayProductLessThanK(nums1, 100));

        int[] nums2 = {1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums2, 0));

        int[] nums3 = {1, 1, 1};
        System.out.println(numSubarrayProductLessThanK(nums3, 2));
    }
}

