package by_topic.Trees;

public class LCAInTree {
    /*
     *            10
     *        6       14
     *      4    8-12    18
     */

    /**
     * LCA for a binary tree
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static Node lowestCommonAncestor(Node root, Node p, Node q) { // 10, 4, 8 => 6
        if( root == p || root == q || root == null)
            return root;
        Node left = lowestCommonAncestor( root.left,  p,  q);
        Node right = lowestCommonAncestor( root.right,  p,  q);

        if(left != null && right != null)
            return root;

        return left == null ? right : left;
        // this steps executed when lca is immediate to both p and q
    }

    /**
     * LCA for a BST
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static Node lowestCommonAncestorForBST(Node root, Node p, Node q) { // 10, 4, 8 => 6
        if( root.data > Math.max( p.data, q.data )) {
            return lowestCommonAncestorForBST(root.left, p , q);
        }
        else if( root.data < Math.min( p.data, q.data )) {
            return lowestCommonAncestorForBST(root.right, p , q);
        }
        else {
            return root;
        }     // this steps executed when lca is immediate to both p and q
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(10);
        Node rootLeft = new Node(6);
        Node rootRight = new Node(14);
        Node rootLeftL = new Node(4);
        Node rootLeftR = new Node(8);
        Node rootRightL = new Node(12);
        Node rootRightR = new Node(18);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftL;
        rootLeft.right = rootLeftR;
        rootRight.left = rootRightL;
        rootRight.right = rootRightR;

        Node lcaNode = lowestCommonAncestor(root, rootLeftL, rootLeftR);
        System.out.println (" LCA for (4,8)) is :: " + lcaNode.data);
        lcaNode = lowestCommonAncestorForBST(root, rootRightL, rootRight);
        System.out.println (" LCA for (12,14)) is :: " + lcaNode.data);
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
