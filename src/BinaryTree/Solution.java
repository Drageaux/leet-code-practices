package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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
}