
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
  }
}

public class RightSideView{

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        System.out.print("Right Side View: ");

        while (!q.isEmpty()) {

            int n = q.size();

            for (int i = 0; i < n; i++) {

                TreeNode node = q.poll();

                if (i == n - 1)
                    System.out.print(node.val + " ");

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
        }
    }
}
