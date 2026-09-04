public class ancestor_binarytre{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        // If root is null, return null
        if (root == null) {
            return null;
        }

        // If root is p or q, root is the answer
        if (root == p || root == q) {
            return root;
        }

        // Search in left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Search in right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // One node found on each side
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found a node
        if (left != null) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // p = 5, q = 1
        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor = " + result.val);
    }
}
