package stack;

/*
    단점 : 두배확장을 너무 많이 하면 메모리 오버플로우가 발생할 수 있음.
 */

public class DynArrayStack { // 반복적인 두배 확장
    private int top;
    private int capacity;
    private int[] array;

    public DynArrayStack() {
        top = -1;
        capacity = 1;
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isStackFull() {
        return (top == capacity -1);
    }

    public void push(int data) {
        if (isStackFull()) { //stack이 꽉차면 doubleStack() 함수로 2배로 늘려줌
            doubleStack();
        }
        array[++top] = data;
    }

    private void doubleStack(){
        //array 의 길이를 기존의 capacity의 2배로 늘림
        int newArray[] = new int[capacity*2];
        //System.arraycopy를 통해 배열을 복사
        //첫번쨰 매개변수는 복사할려는 대상, 시작위치, 끝위치 없으면 전체, 복사하는 대상, 시작위치, 끝위치
        System.arraycopy(array, 0, newArray, 0, capacity);
        //capacity를 2배로 늘려줌
        capacity = capacity*2;
        //array를 2배로 늘리고 array를 복사한 newArray로 교체
        array = newArray;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("StackOverflow");
        }
        return array[top--];
    }

    public void deleteStack() {
        top = -1;
    }


}
