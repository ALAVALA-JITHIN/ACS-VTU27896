public class ancestor_binarysearch{

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

        // Both nodes are smaller than root
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Both nodes are greater than root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // They are on different sides,
        // or root itself is p or q
        return root;
    }

    public static void main(String[] args) {

        /*
                  6
                /   \
               2     8
              / \   / \
             0   4 7   9
                / \
               3   5
        */

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;          // 2
        TreeNode q = root.right;         // 8

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor = " + result.val);
    }
}
