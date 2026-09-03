```java
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePostorderTraversal{

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

        postorder(root);
    }

    public static void postorder(TreeNode root) {

        if (root == null)
            return;

        postorder(root.left);

        postorder(root.right);

        System.out.print(root.val + " ");
    }
}
```
