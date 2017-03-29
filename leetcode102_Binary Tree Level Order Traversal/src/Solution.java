/**
 * @author shanhq96@gmail.com
 * @ClassName 102_Binary Tree Level Order Traversal
 * @Description Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * @date 2017/3/29-17:10
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<QueueNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new QueueNode(1, root));
            List<Integer> tempList = new ArrayList<>();
            int lastHeight = 1;
            while (!queue.isEmpty()) {
                QueueNode tempNode = queue.poll();//结点出队列
                if (tempNode.height > lastHeight) {//判断当前到了树的第几层,若到了下一层,则将list加入到result中.并重置list
                    result.add(tempList);
                    tempList = new ArrayList<>();
                    lastHeight = tempNode.height;
                }
                tempList.add(tempNode.treeNode.val);//将值加入列表
                if (tempNode.treeNode.left != null) {
                    queue.add(new QueueNode(tempNode.height + 1, tempNode.treeNode.left));
                }
                if (tempNode.treeNode.right != null) {
                    queue.add(new QueueNode(tempNode.height + 1, tempNode.treeNode.right));
                }
            }
            result.add(tempList);//将最后一层的结点加入到result中
        }
        return result;
    }

    class QueueNode {
        int height;//当前结点所在高度.
        TreeNode treeNode;

        public QueueNode(int height, TreeNode treeNode) {
            this.height = height;
            this.treeNode = treeNode;
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