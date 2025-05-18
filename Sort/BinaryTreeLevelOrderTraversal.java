import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//  Definition for a binary tree node.


public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> el = new ArrayList<>();
        if (root == null) return el;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> il = new ArrayList<>();
            while (size != 0) {
                TreeNode currNode = queue.remove();
                size--;
                il.add(currNode.val);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            if (!il.isEmpty()) el.add(il);
        }
        return el;
    }
    //  Definition for a binary tree node.
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
          this.right = right;
    }
}
}
