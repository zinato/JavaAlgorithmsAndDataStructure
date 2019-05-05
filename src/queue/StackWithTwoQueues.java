package queue;

public class StackWithTwoQueues {
    LLQueue queue1;
    LLQueue queue2;
    public StackWithTwoQueues() {
        queue1 = new LLQueue();
        queue2 = new LLQueue();
    }
    public void push(int data) {
        if (queue1.isEmpty()) {
            queue2.enQueue(data);
        } else {
            queue1.enQueue(data);
        }
    }

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
