import java.util.*;

public class binarytreepath{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        findPaths(root, "", result);

        return result;
    }

    public static void findPaths(TreeNode root, String path,
                                 List<String> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.length() == 0) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        // If leaf node, store the path
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Go left
        findPaths(root.left, path, result);

        // Go right
        findPaths(root.right, path, result);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
               \
                5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        System.out.println(result);
    }
}
