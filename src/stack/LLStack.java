//package stack;
//
//import java.util.EmptyStackException;
//import java.util.Stack;
//
////LinkedList로 stack 구현
//public class LLStack extends Stack {
//    /*
//        push(): 리스트의 맨 앞에 항목을 삽입하는 것으로 구현된다.
//        pop(): 리스트가 가장 처음 노드(head/top)를 삭제하는 것으로 구현된다.
//     */
//    private LLNode headNode;
//    public LLStack() {
//        //null을 가르키는 headNode 초기화
//        this.headNode = new LLNode(null);
//    }
//
//    public void push(int data) {
//
//        if (headNode == null) { //처음 데이터 추가시
//            headNode = new LLNode(data);
//        } else if (headNode.getData() == null) {
//            headNode.setData(data);
//        } else {
//            LLNode llNode = new LLNode(data);
//            llNode.setNext(headNode); //headNode위에 새로 추가한 llNode를 올림
//            headNode = llNode; //headNode 를 새로 추가한 llNode로 바꿈
//        }
//    }
//
//    public int top() {
//        if (headNode == null) {
//            return null;
//        } else {
//            return headNode.getData();
//        }
//    }
//
//    public int pop() {
//        if (headNode == null) {
//            throw new EmptyStackException();
//        } else {
//            int data = headNode.getData();
//            headNode = headNode.getNext();
//            return data;
//        }
//    }
//
//    public boolean isEmpty() {
//        if (headNode == null) return true;
//        else return false;
//    }
//
//    public void deleteStack() {
//        headNode = null;
//    }
//
//
//}
