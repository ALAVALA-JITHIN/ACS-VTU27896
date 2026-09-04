public class pathsum{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        // If tree is empty
        if (root == null) {
            return false;
        }

        // If we reached a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Subtract current node value
        int remainingSum = targetSum - root.val;

        // Check left or right subtree
        return hasPathSum(root.left, remainingSum)
                || hasPathSum(root.right, remainingSum);
    }

    public static void main(String[] args) {

        // Create tree
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        // Target sum
        int targetSum = 22;

        // Call function
        boolean result = hasPathSum(root, targetSum);

        // Print result
        System.out.println(result);
    }
}
