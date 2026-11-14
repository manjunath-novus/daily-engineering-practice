
import java.util.Arrays;

public class RearrangeArrayBySign {

    public static int[] rearrange(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = rearrange(nums);

        System.out.println("Original: " + Arrays.toString(nums));
        System.out.println("Rearranged: " + Arrays.toString(result));
    }
}
