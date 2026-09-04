import java.util.*;

public class verticalorder{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();

        queue.offer(root);
        columns.offer(0);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            int col = columns.poll();

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            // Left child
            if (node.left != null) {
                queue.offer(node.left);
                columns.offer(col - 1);
            }

            // Right child
            if (node.right != null) {
                queue.offer(node.right);
                columns.offer(col + 1);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        // Creating the tree
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calling vertical traversal
        List<List<Integer>> result = verticalTraversal(root);

        // Printing result
        System.out.println(result);
    }
}
