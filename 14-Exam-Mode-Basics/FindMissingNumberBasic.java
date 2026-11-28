
public class FindMissingNumberBasic {

    public static int findMissingNumber(int[] nums, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        System.out.println(findMissingNumber(arr1, 5));

        int[] arr2 = {1, 3, 4, 5};
        System.out.println(findMissingNumber(arr2, 5));

        int[] arr3 = {2, 3, 4, 5};
        System.out.println(findMissingNumber(arr3, 5));
    }
}
