package queue;

//LinkedList로 구현한 Queue
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
        int data = 0; //data를 0으로 초기화
        if (isEmpty()) { //isEmpty가 true이면 에러를 던진다.
            throw new ArrayQueue.EmptyQueueException();
        } else {
            data = frontNode.getData(); //맨앞에있는 frontNode의 데이터를 가져와서 data에 할당함
            frontNode = frontNode.getNext();//frontNode를 한칸 옮겨줌
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
