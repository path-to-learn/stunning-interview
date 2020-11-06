package by_topic.Trees;

/**
 *      Provides a pattern which maintains 2 variables from dfs. Very Important
 */
public class BinaryTreeMaxPath {

    static int maxValue;

    private static int maxPathDown(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node rootLeft = new Node(6);
        Node rootRight = new Node(14);
        Node rootLeftL = new Node(4);
        Node rootLeftR = new Node(8);
        Node rootRightL = new Node(120);
        Node rootRightR = new Node(180);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftL;
        rootLeft.right = rootLeftR;
        rootRight.left = rootRightL;
        rootRight.right = rootRightR;

        /*
         *       10
         *    6       14
         *  4  8   120  180
         */

        int result = maxPathDown(root);
        System.out.println(result); // 10->14->180 is max sum path which is 204
    }

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left1) {
            left = left1;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right1) {
            right=right1;
        }
    }
}
