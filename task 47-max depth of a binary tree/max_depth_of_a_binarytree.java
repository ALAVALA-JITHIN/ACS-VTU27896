public class max_depth_of_a_binarytree{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {

        // If tree is empty
        if (root == null) {
            return 0;
        }

        // Find left subtree depth
        int leftDepth = maxDepth(root.left);

        // Find right subtree depth
        int rightDepth = maxDepth(root.right);

        // Return the larger depth + current node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9   20
                  / \
                 15  7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxDepth(root);

        System.out.println("Maximum Depth = " + result);
    }
}
