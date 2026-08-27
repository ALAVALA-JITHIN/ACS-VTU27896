import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (!stack.isEmpty() &&
                   asteroid < 0 &&
                   stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Top asteroid is smaller, so remove it
                    stack.pop();
                }

                else if (stack.peek() == -asteroid) {
                    // Both asteroids have same size
                    stack.pop();
                    destroyed = true;
                    break;
                }

                else {
                    // Current asteroid is smaller
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        AsteroidCollision obj = new AsteroidCollision();

        int[] asteroids = {5, 10, -5};

        int[] result = obj.asteroidCollision(asteroids);

        System.out.println(Arrays.toString(result));
    }
}
