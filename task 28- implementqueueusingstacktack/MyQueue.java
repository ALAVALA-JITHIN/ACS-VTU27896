import java.util.Stack;

public class MyQUEUE{

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int peek() {
        moveElements();
        return output.peek();
    }

    public int pop() {
        moveElements();
        return output.pop();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void moveElements() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
