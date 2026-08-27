import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        int j = 0;

        for (int value : pushed) {

            stack.push(value);

            // Remove elements when they match popped[]
            while (!stack.isEmpty() &&
                   j < popped.length &&
                   stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        ValidateStackSequences obj = new ValidateStackSequences();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        System.out.println(
            obj.validateStackSequences(pushed, popped)
        );
    }
}
