public class MiddleOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        MiddleOfLinkedList obj = new MiddleOfLinkedList();

        // Creating: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = obj.middleNode(head);

        System.out.println("Middle node: " + middle.val);

        // Print from middle to the end
        System.out.print("Output: ");

        while (middle != null) {
            System.out.print(middle.val);

            if (middle.next != null) {
                System.out.print(" -> ");
            }

            middle = middle.next;
        }
    }
}
