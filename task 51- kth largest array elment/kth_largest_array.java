import java.util.*;

public class kth_largest_array{

    public static int findKthLargest(int[] nums, int k) {

        // Sort the array
        Arrays.sort(nums);

        // kth largest element
        return nums[nums.length - k];
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};

        int k = 2;

        int result = findKthLargest(nums, k);

        System.out.println("Kth Largest Element = " + result);
    }
}
