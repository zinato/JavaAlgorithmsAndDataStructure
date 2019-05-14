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

    public void setData(int data){
        this.data = data;
    }
    public int getData() {
        return this.data;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public  BinaryTreeNode getLeft() {
        return this.left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getRight() {
        return this.right;
    }
}
