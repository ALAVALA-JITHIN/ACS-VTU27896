class MyCircularDeque {

    int[] q;
    int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        front = (front - 1 + capacity) % capacity;
        q[front] = value;

        if (size == 0)
            rear = front;

        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % capacity;
        q[rear] = value;

        if (size == 0)
            front = rear;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        rear = (rear - 1 + capacity) % capacity;
        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;

        return q[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;

        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class CircularDeque{

    public static void main(String[] args) {

        MyCircularDeque dq = new MyCircularDeque(3);

        System.out.println(dq.insertLast(10));
        System.out.println(dq.insertLast(20));
        System.out.println(dq.insertFront(5));

        System.out.println("Front: " + dq.getFront());
        System.out.println("Rear: " + dq.getRear());

        System.out.println("Delete Front: " + dq.deleteFront());

        System.out.println("Front: " + dq.getFront());
        System.out.println("Rear: " + dq.getRear());

        System.out.println("Delete Rear: " + dq.deleteLast());

        System.out.println("Front: " + dq.getFront());
        System.out.println("Rear: " + dq.getRear());
    }
}

