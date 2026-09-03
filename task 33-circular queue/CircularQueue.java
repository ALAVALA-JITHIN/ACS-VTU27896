
import java.util.*;

class MyCircularQueue{
    int[] q;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        rear = (rear + 1) % capacity;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return q[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class CircularQueue{

    public static void main(String[] args) {

        MyCircularQueue cq = new MyCircularQueue(3);

        System.out.println(cq.enQueue(10));
        System.out.println(cq.enQueue(20));
        System.out.println(cq.enQueue(30));

        System.out.println("Front: " + cq.Front());
        System.out.println("Rear: " + cq.Rear());

        System.out.println("Dequeue: " + cq.deQueue());

        System.out.println(cq.enQueue(40));

        System.out.println("Front: " + cq.Front());
        System.out.println("Rear: " + cq.Rear());
    }
}
