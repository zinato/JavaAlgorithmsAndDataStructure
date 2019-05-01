package queue;


/**
 * 동적 원형 배열 구현
 */
public class DynArrayQueue  {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    private DynArrayQueue() {
        capacity = 1;
        front = -1;
        rear = -1;
        array = new int[1];
    }

    public static DynArrayQueue createDynArrayQueue() {
        return new DynArrayQueue();
    }

    public boolean isEmpty() { // front가 -1이면 Queue가 비었다는 뜻.
        return (front == -1);
    }

    public boolean isFull() { //rear에서 하나를 더한값을 전체용량을 나눈 나머지가 front와 같다는 것은 꽉 찼다는 의미
        return ( (rear+1) % capacity == front);
    }

    public int getQueueSize() {
        if (front == -1) return 0;
        int size = (capacity-front+rear+1) % capacity; //+1을 하는 이유는 배열은 0부터 시작하기 때문이다.
        if (size == 0) { //위 수식으로 했을 때 size가 0이 나오면 capacity가 size라는 것.
            return capacity;
        } else {
            return  size;
        }
    }

    private void resizeQueue() {
        int initCapacity = capacity;
        capacity *= 2;
        int[] oldArray = array;
        array = new int[this.capacity];
        for (int i=0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
        if (rear < front) {
            for(int i=0; i < front; i++) {
                array[i+initCapacity] = this.array[i];
                array[i] = null;
            }
            rear = rear + initCapacity;
        }
    }

    public void enQueue(int data) {
        if (isFull()) resizeQueue();
        rear = (rear+1) % capacity;
        array[rear] = data;
        if (front == -1) front = rear;
    }

    public int deQueue() {
        int data = 0; //null is error.
        if (isEmpty()) {throw new ArrayQueue.EmptyQueueException();}
        else {
            data = array[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return data;
        }

    }




}
