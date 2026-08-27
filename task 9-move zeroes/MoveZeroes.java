import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int insertPosition = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[insertPosition++] = nums[i];
            }
        }

        // Fill the remaining positions with zero
        while (insertPosition < nums.length) {
            nums[insertPosition++] = 0;
        }
    }

    public static void main(String[] args) {

        MoveZeroes s = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};

        s.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
