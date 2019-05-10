package tree;

public class Question01 {
    //이진 트리의 항목 중에 최대값을 찾는 알고리즘을 구하라
    /*
        풀이방법 : 왼쪽 서브트리에서 가장 큰 값을 찾고 오른쪽 서브트리에서 가장 큰 값을 찾아 뿌리노드의 데이터와 비교해서
        최대값을 찾는다.
     */
    public int FindMax(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE; //자바에서는 Integer.MIN_VALUE가 int형 최소값
        int root_val, left, right = 0;
        if (root != null) {
            root_val = root.getData();
            left = FindMax(root.getLeft());
            right = FindMax(root.getRight());
            if (left > right)
                max = left;
            else max = right;
            if (root_val > max)
                max = root_val;
        }
        return max;
    }

    //노드의 개수를 구하는 알고리즘을 구하여라
    public int countOfNode(BinaryTreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        } else {
            count = 1 + countOfNode(root.getLeft()) + countOfNode(root.getRight());
        }
        return count;
    }
}

