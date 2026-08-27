import java.util.Arrays;

public class solution{

    public static int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        // Square each element
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int head = 0;
        int tail = nums.length - 1;

        // Fill result from right to left
        for (int pos = nums.length - 1; pos >= 0; pos--) {

            if (nums[head] > nums[tail]) {
                result[pos] = nums[head];
                head++;
            } else {
                result[pos] = nums[tail];
                tail--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        System.out.println("Sorted Squares: " + Arrays.toString(result));
    }
}
