package by_topic.Trees;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorder {
    /**
        3
     9    20
        15  7
    */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
    private Map<Integer, Integer> indicesMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        indicesMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indicesMap.put(inorder[i], i);
        }
        return build(0, inorder.length, 0, postorder.length);
    }

    private TreeNode build(int inLow, int inHigh, int postLow, int postHigh) {
        if (inLow == inHigh || postLow == postHigh) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postHigh - 1]);

        int rootIndex = indicesMap.get(root.val);
        int postThreshold = postLow + (rootIndex - inLow);

        root.left = build(inLow, rootIndex, postLow, postThreshold);
        root.right = build(rootIndex + 1, inHigh, postThreshold, postHigh - 1);

        return root;
    }

    public static void main(String[] args) {

        BinaryTreeFromInorderPostorder obj = new BinaryTreeFromInorderPostorder();
        TreeNode node = obj.buildTree( obj.inorder, obj.postorder );
        printTree(node);
    }

    private static void printTree(TreeNode node) {
        if (node != null) {
            printTree( node.left );
            System.out.print (node.val + " ");
            printTree( node.right );
        }
    }
}
