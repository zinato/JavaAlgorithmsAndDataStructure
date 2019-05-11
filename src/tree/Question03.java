package tree;

public class Question03 {
    //이진 트리의 항목을 검색하는 알고리즘을 구하라.
    public boolean FindInBinaryTreeUsingRecursion(BinaryTreeNode root, int data) {
        boolean temp;
        //트리가 비었을 경우 데이터가 없으므로 false를 리턴한다.
        if (root == null) {
            return false;
        } else if (data == root.getData()) {
            return true;
        } else {
            temp = FindInBinaryTreeUsingRecursion(root.getLeft(), data);
            if (temp != true) {
                return temp;
            } else {
                return (FindInBinaryTreeUsingRecursion(root.getRight(), data));
            }
        }
    }
}
