public class LinkedListCycleII {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Find starting node of cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        Node result = detectCycle(head);

        if (result != null) {
            System.out.println("Cycle starts at node: " + result.data);
        } else {
            System.out.println("No cycle");
        }
    }
}
