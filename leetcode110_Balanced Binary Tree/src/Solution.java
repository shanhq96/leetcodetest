/**
 * @author shanhq96@gmail.com
 * @ClassName 110_Balanced Binary Tree
 * @Description Given a binary tree, determine if it is height-balanced.
 * For this problem,
 * a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * @date 2017/3/29-16:26
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;//只有当返回-1时,树不是平衡的
    }

    /**
     * 若为平衡二叉树 则返回二叉树的高度.否则返回-1
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) {//树高为0
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {//若左或右子树已经不平衡,或当前树不平衡,则返回-1
            return -1;
        } else {//否则返回树的高度.
            return 1 + Math.max(leftHeight, rightHeight);
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