package tree;

public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    public BinaryTreeNode() {
        data = 0;
        left = null;
        right = null;
    }
    public int getData() {
        return this.data;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }
}
