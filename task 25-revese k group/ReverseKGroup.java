public class ReverseKGroup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverseKGroup(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;

        // Check whether k nodes are available
        Node temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return head;
            temp = temp.next;
        }

        // Reverse k nodes
        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Connect with the remaining list
        head.next = reverseKGroup(current, k);

        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2;

        System.out.println("Original List:");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("After Reversing in K Groups:");
        printList(head);
    }
}
