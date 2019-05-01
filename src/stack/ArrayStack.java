package stack;


/*
    기본 배열 stack의 한계
    - 스택 크기의 최대값이 미리 정해져야하고 바뀔수 없다. 꽉 찬 스택에 새 항목을 푸시하려 하면 이 구현에만 관련된 예외가 발생한다.
 */

public class ArrayStack { //기본배열 stack
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack() { //생성자로 각 인스턴스 변수 초기화
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() { //stack이 비어있는지 확인하는 함수
        /*  이 조건이 참이면 1리턴되고 아니면 0이 리턴된다.
        *   JAVA에서는 false는 0
        * */
        return (top == -1);
    }

    public boolean isStackFull() {
        /*  이 조건이 참이면 1리턴되고 아니면 0이 리턴된다.
         *   JAVA에서는 false는 0
         * */
        return (top == array.length);
    }

    public void push(int data) {
        if (isStackFull()) {
            System.out.println("StackOverFlow");
        }
        else {
            array[++top] = data;
        }

    }

    public int pop() {
        if (isEmpty()) { // top == -1 은 stack이 비었음을 나타낸다.
            System.out.println("");
            return 0;
        } else {
            return (array[top--]);
        }
    }

    public void deleteStack() {
        top = -1;
    }


}
