package queue;


import stack.LLStack;

import java.util.Queue;
import java.util.Stack;

/**
 * Queue의 항목들의 순서를 뒤집는 알고리즘을 제시하라.
 * 큐에 엑세스 할 때 큐 ADT 함수만을 사용해야한다.
 */
public class QueuReversal {
    public static Queue reverseQueue(Queue queue) {
        Stack stack = new LLStack();
        while( !queue.isEmpty()) {
            stack.push(queue.peek());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }
}

// 시간복잡도 : O(n)
