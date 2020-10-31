package by_topic.Iterators;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BSTIterator {

    TreeNode node = null;
    Stack<TreeNode> stack = null;

    public void BSTIteratorInitial(TreeNode root) {
        node = root;
        stack = new Stack<>();
        populate(node);
    }

    public void populate(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int val = stack.peek().val;
        TreeNode node = stack.pop();
        if(node.right!=null) {
            stack.add(node.right);
            populate(node.right.left);
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     *            7
     *          /  \
     *         3   15
     *            /  \
     *           9   20
     */
    @Test
    public void verifyIterator() {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator();
        bstIterator.BSTIteratorInitial(node);
        while(bstIterator.hasNext()) {
            Assert.assertTrue(bstIterator.next() == 3);
            Assert.assertTrue(bstIterator.next() == 7);
            Assert.assertTrue(bstIterator.hasNext() == Boolean.TRUE);
            Assert.assertTrue(bstIterator.next() == 9);
            Assert.assertTrue(bstIterator.hasNext() == Boolean.TRUE);
            Assert.assertTrue(bstIterator.next() == 15);
            Assert.assertTrue(bstIterator.next() == 20);
        }

    }

    /**
     * Definition for a binary tree node.**/
      public class TreeNode {
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
