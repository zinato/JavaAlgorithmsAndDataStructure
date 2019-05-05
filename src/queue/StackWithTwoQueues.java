package queue;

public class StackWithTwoQueues {
    LLQueue queue1;
    LLQueue queue2;
    public StackWithTwoQueues() {
        queue1 = new LLQueue();
        queue2 = new LLQueue();
    }

    //하나의 큐는 항상 비어있어야한다.
    //push 연산은 항상 비어있지 않은 queue에 push한다.
    public void push(int data) {
        if (queue1.isEmpty()) {
            queue2.enQueue(data);
        } else {
            queue1.enQueue(data);
        }
    }

    // pop 연산 을 할 때 비어있지 않은 queue가 비어있는 queue에 하나씩 enqueue를 한다.
    // enqueue한 quque의 가장 마지막 원소를 return 하면 stack의 pop과 같은 효과를 낼 수 있다.

    public int pop() {
        int i, size;
        if (!queue1.isEmpty()) {
            size = queue1.getQueueSize();
            i = 0;
            while (i < size-1) {
                queue2.enQueue(queue1.deQueue());
                i++;
            }
            return queue1.deQueue();
        } else {
            size = queue2.getQueueSize();
            i = 0;
            while (i < size-1) {
                queue1.enQueue(queue2.deQueue());
                i++;
            }
            return queue2.deQueue();
        }
    }
}
