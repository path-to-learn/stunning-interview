package by_topic.Trees;

public class SoredArrayToBST {
    private static class Node {

        Node left;
        Node right;
        int val;
        Node (int value) {
            this.val = value;
        }

    }
    public static void main(String[] args) {

        int[] arr = {-10,-3,0,5,9};

        Node node = getBST(arr, 0, arr.length-1);

        System.out.println (" Print the inorder :: ");
        inorder (node);
    }

    private static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(" " + node.val);
            inorder(node.right);
        }
    }

    private static Node getBST(int[] arr, int low, int high) {

        if (high < low)
            return null;
        int mid = low + (high-low) / 2;

        Node node = new Node (arr[mid]);

        node.left = getBST(arr, low, mid-1);
        node.right = getBST(arr, mid+1, high);

        return node;

    }

/*
           0
      -10      5
     N   -3  n   9

 */
}
