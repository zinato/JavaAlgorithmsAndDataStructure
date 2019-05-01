package queue;

public class ArrayQueue { //동적 원형 배열로 queue를 구현
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    public ArrayQueue(int size) { // ArrayQueue 초기화
        capacity = size;
        //front와 rear를 -1로 초기화 둘다 -1이면 isEmpty
        front = -1;
        rear = -1;
        array = new int[capacity];
    }

    public static ArrayQueue createQueue(int size) {
        return new ArrayQueue(size);
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return((rear+1) % capacity == front);
    }

    public int getQueueSize() {
        return ((capacity-front+rear+1) % capacity);
    }

    /**
     * enqueue : queue에 데이터를 삽입하는 함수
     * @param data
     */
    public void enQueue(int data) {
        if (isFull()) { //꽉 찼을 시 에러를 throw 함.
            throw new QueueOverflowException();
        } else {
            rear = (rear+1)%capacity; //capacity로 modulus 연산자를 쓰는 이유는 원형 배열이기 떄문이다.
            array[rear] = data;
            if (front == -1) { //맨 처음 삽입 시
                front = rear; // front 는 0이 됨.
            }
        }
    }


    /**
     * dequeue : Queue의 가장 앞부분을 삭제하고 삭제된 요쇼를 반환하는 함수
     * @return 삭제된 요소의 data
     */
    public int deQueue(){
        int data = 0;
        if (isEmpty()) { //
            throw new EmptyQueueException();
        } else {
          data = array[front]; //
          if (front == rear) { //계속 삭제해서 맨끝 요소 삭제 시
              front = rear -1;
          } else {
              front = (front+1)%capacity;
          }
        }
        return data;
    }

    static class QueueOverflowException extends RuntimeException { }
    static class EmptyQueueException extends RuntimeException { }


}
