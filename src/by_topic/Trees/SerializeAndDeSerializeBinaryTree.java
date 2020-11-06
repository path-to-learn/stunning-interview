package by_topic.Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeSerializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize (root, sb);
        return sb.toString();
    }

    private void serialize (TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append("#");
            return;
        }
        sb.append(root.val).append("#");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("#");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.peek().equals("null")) {
            queue.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        // verify
    }
}
