package BinaryTree;

import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode currNode = root;
        List<Integer> result = new ArrayList<Integer>();
        if (currNode == null) return result;

        Stack<TreeNode> needVisit = new Stack<TreeNode>();
        HashSet<TreeNode> noVisit = new HashSet<TreeNode>(); // HashSet has O(1) contains()

        result.add(currNode.val); // root always the first element for preorder
        needVisit.push(currNode);

        while (true) {
            currNode = needVisit.peek();
            if (currNode == null) break;

            // if no subtrees, just pop
            if (currNode.left == null && currNode.right == null) {
                noVisit.add(needVisit.pop());
                if (needVisit.empty()) {
                    break;
                } else {
                    continue;
                }
            }

            if (currNode.left != null && !noVisit.contains(currNode.left)) { // if left is valid
                result.add(currNode.left.val);
                needVisit.push(currNode.left);
                continue;
            } else if (currNode.right != null && !noVisit.contains(currNode.right)) { // if left isn't valid but right is
                result.add(currNode.right.val);
                needVisit.push(currNode.right);
                continue;
            } else { // if neither left nor right is valid
                noVisit.add(needVisit.pop());
                if (needVisit.empty()) {
                    break;
                }
            }
        }
        return result;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode currNode = root;
        List<Integer> result = new ArrayList<Integer>();
        if (currNode == null) return result;

        Stack<TreeNode> needVisit = new Stack<TreeNode>();
        HashSet<TreeNode> noVisit = new HashSet<TreeNode>(); // HashSet has O(1) contains()

        needVisit.push(currNode);

        while (true) {
            currNode = needVisit.peek();
            if (currNode == null) break;

            // if left is valid
            if (currNode.left != null && !noVisit.contains(currNode.left)) {
                // keep sticking left
                needVisit.push(currNode.left);
                continue;
            }

            // if left isn't valid but right is
            if (currNode.right != null && !noVisit.contains(currNode.right)) {
                result.add(currNode.val);
                noVisit.add(needVisit.pop());
                needVisit.push(currNode.right);
                continue;
            }

            // if neither children is valid, add self to result and don't visit self again
            result.add(currNode.val);
            noVisit.add(needVisit.pop());

            if (needVisit.empty()) {
                break;
            }
        }
        return result;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode currNode = root;
        List<Integer> result = new ArrayList<Integer>();
        if (currNode == null) return result;

        Stack<TreeNode> needVisit = new Stack<TreeNode>();
        HashSet<TreeNode> noVisit = new HashSet<TreeNode>(); // HashSet has O(1) contains()

        needVisit.push(currNode);

        while (true) {
            currNode = needVisit.peek();
            if (currNode == null) break;

            // if left is valid
            if (currNode.left != null && !noVisit.contains(currNode.left)) {
                // keep sticking left
                needVisit.push(currNode.left);
                continue;
            }
            // if left isn't valid but right is
            else if (currNode.right != null && !noVisit.contains(currNode.right)) {
                // go right
                needVisit.push(currNode.right);
                continue;
            }
            // if neither children is valid, add self to result and don't visit self again
            else {
                result.add(currNode.val);
                noVisit.add(needVisit.pop());
            }

            if (needVisit.empty()) {
                break;
            }
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode currNode = root;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // List<Integer> result = new ArrayList<Integer>();
        if (currNode == null) return result;

        // first level
        int level = 0;
        List<Integer> firstLevel = new ArrayList<Integer>();
        firstLevel.add(currNode.val);
        result.add(firstLevel);

        // set up queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        HashSet<TreeNode> noVisit = new HashSet<TreeNode>(); // HashSet has O(1) contains()

        List<Integer> currLevel = new ArrayList<Integer>();
        Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
        q.add(currNode);

        // next levels
        while (true) {

            level++;

            while (q.peek() != null) {
                TreeNode child = q.poll();

                if (child.left == null && child.right == null) {
                    continue; // next child
                }

                if (child.left != null) {
                    q.add(currNode.left);
                    currLevel.add(currNode.left.val);
                }
                if (child.right != null) {
                    q.add(currNode.right);
                    currLevel.add(currNode.right.val);
                }

                System.out.println(q.peek().val);

            }

            result.add(level, currLevel);

            if (q.isEmpty()) {
                break;
            }
        }

        return result;
    }
}