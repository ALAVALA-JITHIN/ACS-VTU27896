public class kth_element{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int answer = 0;

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        // Visit left subtree
        int leftResult = kthSmallest(root.left, k);

        if (count == k) {
            return answer;
        }

        // Visit current node
        count++;

        if (count == k) {
            answer = root.val;
            return answer;
        }

        // Visit right subtree
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   6
             / \
            2   4
           /
          1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        int k = 3;

        int result = kthSmallest(root, k);

        System.out.println("Kth Smallest Element = " + result);
    }
}
