import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumK {

    public static int countSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            count += prefixSumCount.getOrDefault(prefixSum - k, 0);

            prefixSumCount.put(
                prefixSum,
                prefixSumCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 1, 1}, 2));
        System.out.println(countSubarrays(new int[]{1, 2, 3}, 3));
        System.out.println(countSubarrays(new int[]{1, -1, 0}, 0));
    }
}