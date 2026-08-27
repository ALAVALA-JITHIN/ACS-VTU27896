public class IntersectionLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node getIntersection(Node headA, Node headB) {

        Node a = headA;
        Node b = headB;

        while (a != b) {
            if (a == null)
                a = headB;
            else
                a = a.next;

            if (b == null)
                b = headA;
            else
                b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {

        // First list
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);

        // Common part
        Node common = new Node(4);
        common.next = new Node(5);

        headA.next.next.next = common;

        // Second list
        Node headB = new Node(9);
        headB.next = common;

        Node result = getIntersection(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node: " + result.data);
        } else {
            System.out.println("No intersection");
        }
    }
}
