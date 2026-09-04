public class diameter_of_a_binarytree{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Find height of left subtree
        int leftHeight = height(root.left);

        // Find height of right subtree
        int rightHeight = height(root.right);

        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight;

        // Update maximum diameter
        diameter = Math.max(diameter, currentDiameter);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = diameterOfBinaryTree(root);

        System.out.println("Diameter = " + result);
    }
}
