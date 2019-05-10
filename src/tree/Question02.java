package tree;

import queue.LLQueue;

public class Question02 {
    //재귀 없이 이진 트리의 항목 중에 최대 값을 찾는 알고리즘을 구하라.
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
    }
}
//에러가 발생함 타입이 잘 안맞는듯 함. 나중에 수정해야함
