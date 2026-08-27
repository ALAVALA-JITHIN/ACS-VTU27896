import java.util.HashMap;
import java.util.Map;

public class Duplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                int diff = i - map.get(nums[i]);

                if (diff <= k) {
                    return true;
                }
            }

            // Update with the latest index
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        boolean result = containsNearbyDuplicate(nums, k);

        System.out.println(result);
    }
}
