package queue;

public class LLQueue {
    private LLNode frontNode; //headNode에 해당
    private LLNode rearNode; // lastNode에 해당
    public LLQueue() {
        this.frontNode = null;
        this.rearNode = null;
    }

    public static LLQueue createQueue() {
        return new LLQueue();
    }

    public boolean isEmpty(){
        return (frontNode == null);
    }

    public void enQueue(int data) {
        LLNode newNode = new LLNode(data);
        if (rearNode != null) {
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if (frontNode == null) { //멘 처음 삽입 시
            frontNode = rearNode;
        }
    }

    public int deQueue(){
        int data = 0;
        if (isEmpty()) {
            throw new ArrayQueue.EmptyQueueException();
        } else {
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;

    }

    public int getQueueSize() {
        if (frontNode == null) {
            return 0;
        }
        int length = 0;
        LLNode currentNode = null;
        while (currentNode.getNext() != null) {
            currentNode = frontNode.getNext();
            length++;
        }
        return length;
    }

}

class LLNode {
    private int data;
    private LLNode next;
    public LLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return this.next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }


}
