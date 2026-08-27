import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures{

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            // Check if today's temperature is greater
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();

                result[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        DailyTemperatures obj = new DailyTemperatures();

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = obj.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
    }
}
