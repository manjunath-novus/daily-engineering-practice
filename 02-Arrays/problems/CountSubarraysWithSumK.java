import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumK {

    public static long countSubarrays(int[] arr, long k) {
        Map<Long, Long> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1L);

        long prefixSum = 0;
        long count = 0;

        for (int num : arr) {
            prefixSum += num;

            count += prefixSumCount.getOrDefault(
                prefixSum - k, 0L
            );

            prefixSumCount.put(
                prefixSum,
                prefixSumCount.getOrDefault(prefixSum, 0L) + 1
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