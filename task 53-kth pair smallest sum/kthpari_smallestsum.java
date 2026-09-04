import java.util.*;

public class kthpari_smallestsum{

    public static List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Add first pair from each nums1 element
        for (int i = 0; i < Math.min(nums1.length, k); i++) {

            // {sum, index1, index2}
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!pq.isEmpty() && result.size() < k) {

            int[] current = pq.poll();

            int sum = current[0];
            int i = current[1];
            int j = current[2];

            // Add pair to result
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);

            result.add(pair);

            // Move to next element in nums2
            if (j + 1 < nums2.length) {

                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};

        int k = 3;

        List<List<Integer>> result =
                kSmallestPairs(nums1, nums2, k);

        System.out.println(result);
    }
}
