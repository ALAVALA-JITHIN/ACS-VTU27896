import java.util.*;

public class pathsumII{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    public static void findPaths(TreeNode root, int targetSum,
                                 List<Integer> path,
                                 List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // Add current node
        path.add(root.val);

        // Check if it is a leaf node and target is reached
        if (root.left == null && root.right == null
                && root.val == targetSum) {

            result.add(new ArrayList<>(path));
        }

        // Go to left
        findPaths(root.left,
                targetSum - root.val,
                path,
                result);

        // Go to right
        findPaths(root.right,
                targetSum - root.val,
                path,
                result);

        // Backtracking
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> result = pathSum(root, targetSum);

        System.out.println(result);
    }
}
