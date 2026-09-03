
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal{

    public static void main(String[] args) {

        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        preorder(root);
    }

    public static void preorder(TreeNode root) {

        if (root == null)
            return;

        System.out.print(root.val + " ");

        preorder(root.left);

        preorder(root.right);
    }
}
```
