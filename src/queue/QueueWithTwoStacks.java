package queue;


import java.util.Stack;

/**
 * 두개의 스택으로 큐를 구현하려면 어떻게 하는가?
 */
public class QueueWithTwoStacks {
    Stack stack1;
    Stack stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public boolean isEmpty() { //stack1에 있는 모든 값을 stack2에 넣었는데도 isEmpty() == true 면 전부 비어있는 것.
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty();
    }

    public void enQueue(Object data) {
        stack1.push(data);
    }

    public Object deQueue() {
        if (stack1.isEmpty()) {
            throw new ArrayQueue.EmptyQueueException();
        } else if (!stack2.isEmpty()) {
            return stack2.pop();
        } else { //stack2가 비었으면 stack1에 있는 값들은 stack2에 푸쉬하고 pop을 함.
            while( !stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

}
