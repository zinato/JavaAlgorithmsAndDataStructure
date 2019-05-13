package tree;

import queue.LLQueue;

public class Question {

    //00. 노드의 개수를 구하는 알고리즘을 구하여라
    public int countOfNode(BinaryTreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        } else {
            count = 1 + countOfNode(root.getLeft()) + countOfNode(root.getRight());
        }
        return count;
    }

    //01. 이진 트리의 항목 중에 최대값을 찾는 알고리즘을 구하라
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

    //02. 재귀 없이 이진 트리의 항목 중에 최대 값을 찾는 알고리즘을 구하라.
    /*
      정답: 레벨순서 탐색을 사용한다.
           시간복잡도: O(n)
           공간복잡도: O(n)
     */
    public int FindMaxUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        int max = Integer.MIN_VALUE;
        LLQueue Q = new LLQueue();
        Q.enQueue(root.getData());
        while(!Q.isEmpty()){
            temp.setData(Q.deQueue());
            if (temp.getData() > max) {
                max = temp.getData();
            }
            if (temp.getLeft()) {
                Q.enQueue(temp.getLeft());
            }
            if (temp.getRight()) {
                Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue();
        return max;
    } //에러가 발생함 타입이 잘 안맞는듯 함. 나중에 수정해야함

    //03. 이진 트리의 항목을 검색하는 알고리즘을 구하라.
    /*
        이진트리에서 구하는 데이터가 있는 노드가 발견되면 참을 리턴함.
        재귀적으로 트리 아래로 내려가면서 각 노드의 데이터와 비교해서 왼쪽이나 오른쪽을 선택한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
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

    //04. 재귀없이 이진 트리 안의 항목을 검색하는 알고리즘을 구하라.
    /*
        레벨 순서 탐색을 사용해서 풀 수 있다.
        데이터를 출력하는 대신에 노드 데이터가 찾고 있는 항목과 같은지 검사한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)

     */
    public boolean SearchUsingLevelOrder(BinaryTreeNode root, int data) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        if (!root) return false;
        Q.enQueue(root);
        while (!Q.isEmpty()) {
            temp = Q.deQueue();
            //여기서 발견되었는지 확인
            if (data == root.getData())
                return true;
            if (temp.getLeft())
                Q.enQueue(temp.getLeft());
            if (temp.getRight())
                Q.enQueue(temp.getRight());
        }
        Q.deleteQueue();
        return false;
    }

}



} // end of Question class

