package tree;

import queue.LLQueue;

public class Question02 {
    //재귀 없이 이진 트리의 항목 중에 최대 값을 찾는 알고리즘을 구하라.
    /*
      정답: 레벨순서 탐색을 사용한다.
     */
    public int FindMaxUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        int max = Integer.MIN_VALUE;
        LLQueue Q = new LLQueue();
        Q.enQueue(root.getData());



        return max;
    }
}
