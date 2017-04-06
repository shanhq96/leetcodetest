import java.util.*;

/**
 * @author shanhq96@gmail.com
 * @ClassName 107_Binary Tree Level Order Traversal II
 * @Description Given a binary tree,
 * return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * @date 2017/3/29-22:05
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<StackNode> queue = new LinkedList<>();
        Stack<StackNode> stack = new Stack<>();
        if (root != null) {
            queue.add(new StackNode(1, root));
            int lastHeight = 1;
            while (!queue.isEmpty()) {
                StackNode tempNode = queue.poll();//结点出队列
                stack.push(tempNode);
                if (tempNode.height > lastHeight) {//判断当前到了树的第几层,若到了下一层,则将list加入到result中.并重置list
                    lastHeight = tempNode.height;
                }
                if (tempNode.treeNode.right != null) {
                    queue.add(new StackNode(tempNode.height + 1, tempNode.treeNode.right));
                }
                if (tempNode.treeNode.left != null) {
                    queue.add(new StackNode(tempNode.height + 1, tempNode.treeNode.left));
                }
            }
            List<Integer> tempList = new ArrayList<>();
            while (!stack.isEmpty()) {
                StackNode tempNode = stack.pop();
                if (tempNode.height < lastHeight) {
                    result.add(tempList);
                    tempList = new ArrayList<>();
                    lastHeight = tempNode.height;
                }
                tempList.add(tempNode.treeNode.val);

            }
            result.add(tempList);//将最后一层的结点加入到result中
        }
        return result;

    }

    private class StackNode {
        int height;//当前结点所在高度.
        TreeNode treeNode;

        public StackNode(int height, TreeNode treeNode) {
            this.height = height;
            this.treeNode = treeNode;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
