/**
 * @author shanhq96@gmail.com
 * @ClassName 111_Minimum Depth of Binary Tree
 * @Description Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @date 2017/3/29-16:50
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {//左子树为空,返回1+右子树的minDepth
            return 1 + minDepth(root.right);
        } else if (root.left != null && root.right == null) {//右子树为空,返回1+左子树的minDepth
            return 1 + minDepth(root.left);
        } else if (root.left == null && root.right == null) {//左右子树为空,返回1
            return 1;
        }else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));//左右子树均不为空
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}