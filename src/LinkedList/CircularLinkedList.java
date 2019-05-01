package LinkedList;

public class CircularLinkedList {

    public class CLLNode {
        private int data; //데이터
        private CLLNode next; // '다음'을 나타내는 포인터
        private CLLNode previous; // '이전'을 나타내는 포인터

        //생성자
        public CLLNode(int data) {
            this.data = data;
        }

        //getter , setter
        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setNext(CLLNode next) {
            this.next = next;
        }

        public CLLNode getNext() {
            return this.next;
        }

        public void setPrevious(CLLNode previous) {
            this.previous = previous;
        }

        public CLLNode getPrevious() {
            return this.previous;
        }
    }

    //원형 연결리스트의 노드 개수 세기
    int CircularListLength(CLLNode headNode) {
        int length = 0; //개수를 세기위한 변수 length
        CLLNode currentNode = headNode;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
               break;
            }
        }
        return length;
    }

    //원형 연결 리스트의 첫번쨰 노드 삭제하기
    void DeleteFromNodeFromCLL(CLLNode head) {
        CLLNode temp = head; //head에 임시 노드를 만듦
        CLLNode current = head; //삭제를 위한 current node, 일종의 우리가 삭제 삽입 위치등을 컨트롤할 수 있는 node.
        if (head == null) { //head가 null이면 List가 비어있는 것이므로 에러메세지 출력 후 반환.
            System.out.println("List empty");
            return;
        }
        while (current.getNext() != head) {
            current.setNext(current.getNext()); //리스트를 돌면서 head이전의 node, 즉 맨 마지막 node를 찾음
        }
        current.setNext(head.getNext()); //삭제될 가장 첫번째 노드의 이전노드의 next를 head 노드의 다음 으로 설정함
        head = head.getNext(); //head도 다음 노드로 이동시킴
        temp = null; // 맨앞 node 삭제
        return; //함수 반환
    }



}
