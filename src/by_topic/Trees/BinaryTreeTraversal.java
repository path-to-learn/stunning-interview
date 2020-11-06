package by_topic.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
    /**
                100
            50       150
       25  175    120     200

     **/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(100);
            root.left = new TreeNode(50);
            root.right = new TreeNode(150);
            root.left.left = new TreeNode(25);
            root.left.right = new TreeNode(175);
            root.right.left = new TreeNode(120);
            root.right.right = new TreeNode(200);

            TreeNode rootM = new TreeNode(100);
            rootM.left = new TreeNode(150);
            rootM.right = new TreeNode(50);
            rootM.left.left = new TreeNode(200);
            rootM.left.right = new TreeNode(120);
            rootM.right.left = new TreeNode(75);
            rootM.right.right = new TreeNode(25);

            System.out.println("PreOrder is : ");
            preOrder(root);
            System.out.println("\nInOrder is : ");
            inOrder(root);
            System.out.println("\nPostOrder is : ");
            postOrder(root);
            System.out.println("\nPostOrder Another is : ");
            postOrderAnother(root);
            System.out.println("\nBFS Traversal is : ");
            bfs(root);

            System.out.println("\nAre they mirror images : " + isMirrorImage(root, rootM));

        }

        private static boolean isMirrorImage(TreeNode root, TreeNode rootM) {
            // if both are empty
            if ((root==null && rootM == null) )
                return true;
            // if only one is empty
            if ((root==null || rootM == null) )
                return false;
            if (root.val != rootM.val)
                return false;
            return isMirrorImage(root.left, rootM.right) && isMirrorImage(root.right, rootM.left);
        }

        private static void preOrder(TreeNode root) {
            if (root != null) {
                System.out.print(root.val + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        private static void inOrder(TreeNode root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.val + " ");
                inOrder(root.right);
            }
        }

        private static void postOrder(TreeNode root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.val + " ");
            }
        }
        private static void postOrderAnother(TreeNode root) {
            if (root == null)
                return;

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");


        }

        /**
                10
            50     15
          25 17   11 20
         **/
        private static void makeMirrorImage(TreeNode root) {
            if (root != null) {
                makeMirrorImage (root.left);
                makeMirrorImage(root.right);
                TreeNode node = root.left;
                root.left = root.right;
                root.right = node;
                //makeMirrorImage(root.right); // Note: Not here
            }
        }

        // use queue for the bfs
        private static void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>(  );
            queue.add( root );
            TreeNode node;
            while (!queue.isEmpty()) {
                node = queue.poll();
                System.out.print( node.val + " " );
                if (node.left != null)
                    queue.add( node.left );
                if (node.right != null)
                    queue.add( node.right );
            }

        }
    }
}
