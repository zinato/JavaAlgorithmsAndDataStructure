Tree 이해 
=============

## 1. Tree란 무엇인가?

- Tree는 연결 리스트 (LinkedList)와 유사한 데이터 구조이다.
- 비선현정 데이터 구조의 한 예이다.

### Tree의  장점

- 탐색, 삽입, 삭제가 빠르다.
- 이미 정렬된 Array에서는 삽입, 삭제 작업이 효율이 좋지 않다.
- LinkedList는 검색 성능이 느리다. 

## 2. Tree 용어 

              O <- root             <- Level-0
            /   \  <- edge
           O     O                  <- Level-1
          /    /   \
         O   O       O <- leaf      <- Level-2
 
 - root(뿌리) : 트리의 Root는 부모가 없는 노드이다. 최대 한개의 뿌리노드가 있을 수 있다. 모든 노드의 조상이다.
 - edge : 부모로 부터 자식에게 이어지는 선  
 - leaf(잎) : 자식이 없는 노드를 leaf라고 한다.
 - siblings(형제) : 같은 부모를 가진 자식들을 siblings라고 한다. 
 - ancestor : 예를 들어 root부터 leaf 노드 c에 이르기까지 leaf 위의 노드들이 root -> a -> b -> c 순서대로 있다고 했을 시 root,a,b 는 
  c의 ancestor(조상)이다.
 - descendant(자손) : 위의 예를 이어서 c는 b의 자손 노드이다.     
 - Level : 주어진 깊이의 모든 노드의 집합을 그 트리의 레벨이라고 한다. 
 - **노드의 깊이** : 뿌리로 부터 그 노드 까지의 경로의 길이이다. 예를 들어 root -> a -> b -> c 에서 b의 깊이는 2이다. 
 - **노드의 높이** : 노드로 부터 가장 깊은 노드까지의 경로의 길이이다. 뿌리 노드만 있는 트리의 깊이는 0이다. root -> a -> b -> c 트리의 높이는 
 3이다.
 - 노드의 크기 : 크기는 자기 자신을 포함하여 그 노드가 가진 자손의 수이다. root -> a -> b 트리의 크기는 3이다. 
 - skew(경사) : 트리의 모든 노드가 한개의 자식만을 가질 때 (leaf 제외) 모든 노드가 왼쪽 자식만을 가지면 왼쪽 경사트리, 반대면 오른쪽 경사 트리, 
 왼쪽 오른쪽 등을 가지고 있으면 경사트리 라고 한다. 
 
## 3. 이진 트리 (binary tree)

- 각 노드가 자식이 없거나, 한개 혹은 두개의 자식을 가질 때 이진 트리라고 한다. 
- 빈 트리 역시 유효한 이진트리이다. 
- 이진 트리는 뿌리, 왼쪽 서브트리, 오른쪽 서브트리 라고 불리는 두개의 분리된 이진트리로 구성되어 있다.

### 이진트리의 종류

#### 1. 엄격한 이진트리 (strict binary tree)

- 모든 노드가 두개의 자식을 가지거나 자식이 없을 때 엄격한 이진트리라고 함.  

                O <- root
              /   \  
             O      O  
                  /   \
                O       O
  
  
#### 2. 포화 이진트리 (full binary tree)

- 모든 노드가 두개의 자식을 가지고 있고 같은 레벨에 있을 때 포화 이진 트리라고 한다. 

                 O <- root
              /     \  
             O        O  
           /   \    /   \
          O     O  O     O
          
#### 3. 완전 이진트리 (complete binary tree)

- 이진트리의 높이를 h라고 하자. 
- 뿌리부터 시작하여 각 노드에 번호를 매기면 1부터 시작해서 완전한 순열을 얻는다. 
- 모든 leaf 노드가 h나 h-1에 있고 순열에서 빠진 숫자가 없을 때 완전 이진트리라고 한다.
- 왼쪽부터 순서대로 추가하는 이진트리. 

            1 
           / \
          2   3
         / \
        4   5
        
 
 
### 이진트리의 속성

- 포화 이진 트리의 노드 개수 : n은 2^(h+1)-1 이다. 모두 같은 높이의 레벨에 있기 때문에 각 레벨의 노드를 다 더해야 한다. 
- 완전 이진 트리의 노드 개수 : n은 2^h(최소값)과 2^(h+1)-1(최대값) 사이에 있다. 
- 포화 이진트리의 잎의 개수는 2h 이다. 
- n개의 노드를 가진 완전 이진트리의 null 연결의 개수는 n + 1

### 이진트리의 구조 
```
 class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
 }
```
- 데이터가 정수라고 가정. 데이터 필드를 가진다. 
- 왼쪽, 오른쪽 자식 노드를 가리키는 필드를 가진다.

 
#### 이진트리 연산

- Tree 항목 삽입
- Tree 항목 삭제
- 항목 검색하기
- Tree 탐색하기 등등

## 4. 이진트리 탐색 

- 트리의 모든 노드를 방문하는 과정을 트리탐색이라 한다. 
- 각 노듣 오직 한번씩 처리되지만 한 번 이상 방문될 수 있다. 
- 탐색에서는 모든 노드가 처리되지만 검색에서는 찾는 노드가 발견되면 멈춘다. 

### 탐색 가능성 

- 뿌리부터 시작해서 모든 노드를 탐색하는 데는 세가지 단계가 있다. 
    * 현재 노드에 대해 어떤 작업 수행하기 - 노드 방문 'D'
    * 왼쪽 자식 노드 탐색하기 - 'L'
    * 오른쪽 자식 노드 탐색하기 - 'R'
    
1. LDR : 왼쪽 트리 처리 -> 현재 노드 데이터를 처리 -> 오른쪽 트리 처리
2. LRD : 왼쪽 트리 처리 -> 오른쪽 트리 처리 -> 현재 노드 데이터를 처리
3. DLR : 현재 노드 데이터를 처리  -> 왼쪽 트리 처리 -> 오른쪽 트리 처리
4. DRL : 현재 노드 데이터를 처리  -> 오른쪽 트리 처리 -> 왼쪽 트리 처리
5. RDL : 오른쪽 트리 처리 -> 현재 노드 데이터를 처리 -> 왼쪽 트리 처리
6. RLD : 오른쪽 트리 처리 -> 왼쪽 트리 처리 -> 현재 노드 데이터를 처리

### 탐색 분류하기 

- 현재노드가 처리되는 순서에 따라 분류가 된다. 
- 전위(Preorder) 탐색(DLR)
- 중위(Inorder) 탐색(LDR)
- 후위(Postorder) 탐색(LRD)
- 레벨 순서 탐색(Level Order Traversal) : 너비 우선 탐색(Breadth First Traversal,그래프 알고리즘의 BFS)의 영향을 받은 것이다. 

### 전위 탐색

- 각 노드의 탐색은 각 서브 트리를 탐색 하기전에 처리된다. 
- 왼쪽 서브 트리 처리 후 오른쪽 서브 트리로 이동하려면 **뿌리의 정보**가 유지되어야 한다.
- 전위 탐색의 ADT는 Stack이다. Stack의 LIFO 구조 때문에 오른쪽 서브 트리에 대한 정보를 역순으로 얻는 것이 가능하다.

##### 전위 탐색 정의

- 뿌리를 방문한다.
- 전위 탐색으로 왼쪽 트리를 탐색한다.
- 전위 탐색으로 오른쪽 트리를 탐색한다. 
```java
   public void PreOrder(BinaryTreeNode root){
    if (root != null) {
        System.out.println(root.getData());
        PreOrder(root.getLeft());
        PreOrder(root.getRight());
    }
   }
 //  시간 복잡도 :O(n)
 //  시간 복잡도 :O(n)
```
### 비재귀적 전위 탐색

- 비재귀적 전위 탐색에서는 왼쪽 서브 트리 탐색을 끝내면 오른쪽 서브 트리로 가기 위해 현재 노드를 기억하는 스택이 필요하다.
    1. 현재 노드를 처리한 뒤 왼쪽 서브 트리로 가기 전에 현재 노드를 스택에 저장한다. 
    2. 왼쪽 서브 트리 처리가 끝난 뒤 항목을 팝해서 오른쪽 서브 트리로 이동한다. 
    3. 1,2 과정을 스택이 비지 않는 동안 계속한다. 

```java
    public void PreOrderNonRecursive(BinaryTreeNode root){
        if (root == null) return null;
        LLStack stack = new LLStack();
        while(true){
            while(root != null){
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if(stack.isEmpty()) break;
            root = (BinaryNodeTree) stack.pop();
            root = root.getRight();
        }
        return;
    }
 //   시간 복잡도: O(n)
 //   공간 복잡도: O(n)
```

### 중위 탐색

- 왼쪽 서브 트리를 중위 탐색으로 탐색한다.
- 뿌리노드를 방문한다.
- 오른쪽 서브트리를 중위 탐색으로 탐색한다.

```java
    public void InOrder(BinaryTreeNode root){
        if (root != null) {
            InOrder(root.getLeft());
            System.out.println(root.getData());
            InOrder(root.getRight());
        }
    }
//   시간 복잡도 : O(n)
//   공간 복잡도 : O(n)
``` 

### 비재귀적 중위 탐색
- 비재귀적 중위 탐색은 비재귀적 전위탐색과 비슷하다.
- 차이점은 왼쪽 서브 트리로 가기전에 노드를 처리하는 대신에 pop한 뒤 왼쪽 서브 트리 처리가 끝난 뒤 노드를 처리하는 것이다.
```java
    public void InOrderNonRecursive(BinaryTreeNode root){
        if (root == null) return null;
        LLStack stack = new LLStack();
        while (true) {
            while (root != null) {
                //왼쪽 먼저 탐색 
                stack.push(root);  
                root = root.getLeft();
            }
            if (stack.isEmpty()) break;
            //왼쪽 탐색 후 현재 노드 탐색 
            root = (BinaryTreeNode) stack.pop();
            System.out.println(root.getData());
            //오른쪽 노드 탐색
            root = root.getRgiht();
        }
        return;
    }
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(n)
```
### 후위 탐색

- 왼쪽 서브 트리를 후위 탐색으로 탐색한다.
- 오른쪽 서브 트리를 후위 탐색으로 탐색한다.
- 뿌리 노드를 방문한다. 
```java
    public void PostOrder(BinaryTreeNode root){
        if (root) {
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(n)
```   

### 비재귀적 후위 탐색

- 전위, 중위 탐색과 달리 두번 탐색하는 노드가 발생함. 
- 두번째 방문에만 처리가 되어야 함.
- 스택으로부터 항목을 pop한 뒤 이 항목과 스택의 최상위 항목의 오른쪽이 같은지 검사하여 왼쪽 서브트리를 끝내고 온 것인지 오른쪽 서브트리를
끝내고 온 것인지 구분할 수 있다. 
- 이 둘이 같다면 왼쪽 서브트리와 오른쪽 서브트리 처리를 마친 것이다. 스택을 한번 더 pop한 뒤 데이터를 출력한다.

```java 
   public void PostOrderNonRecursive(BinaryTreeNode root){
        LLStack stack = new LLStack();
        while(1){
            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {
                if (stack.isEmpty()) {
                    System.out.println("Stack is Empty");
                    return;
                } else {
                    if (stack.top().getRight() == null) {
                        root = stack.pop();
                        System.out.println(root.getData());
                        if (root == stack.top().getRight()) {
                            System.out.prinlnt(stack.top(stack.getData());
                            stack.pop();
                        }
                    }
                    if (!stack.isEmpty()) {
                        root = stack.top().getRight();
                    } else {
                        root = null;
                    }
                }
                
            }
        }
        stack.deleteStack();
   }
//   시간 복잡도 : O(n)
//   공간 복잡도 : O(n)
``` 
  
### 전위, 중위, 후위 탐색의 선택방법

- 순서는 중요하지 않고 노드를 전부 방문하기만 하면 된다면 3가지 방법 모두 상관이 없다. 
- 자식 노드를 처리한 다음에 부모 노드를 처리해야 한다면 후위 탐색을 사용한다.
- 부모 노드를 처리한 다음에 자식 노드를 처리해야 한다면 전위 탐색을 사용한다. 

### 레벨 순서 탐색

- 각 노드를 레벨 순으로 검사하는 탐색방법이다. 
- 스택이 아니라 큐를 사용한다. 

1. 뿌리 노드를 방문한다. 
2. 레벨 l을 방문하는 동안 레벨 l+1의 모든 항목을 큐에 저장한다.
3. 다음 레벨로 가서 그 레벨의 모든 노드를 방문한다. 
4. 1~3을 모든 레벨이 끝날 때까지 반복한다. 

```java
    public void LevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue queue = new LLQueue();
        if (root == null) {
            return;
        } else {
            queue.enQueue(root);
            while(!queue.isEmpty()){
                temp = queue.deQueue();
                //현재 노드 처리
                System.out.println(temp.getData());
                if (temp.getLeft()) { 
                    queue.enQueue(temp.getLeft());
                }                    
                if (temp.getRight()) {
                    queue.enQueue(temp.getRight());
                }
                queue.deleteQueue();
            }
        }
    }
    //시간 복잡도 : O(n)
    //공간 복잡도 : O(n) 최악의 경우 마지막 레벨의 모든 항목이 순차적으로 큐에 있을 수 있기 때문에
```  
 
## 범용 트리 (N항 트리)

- 자식 노드가 4~5 개 이상이 되는 트리들은 어떻게 표현할 수 있을까? 각각을 메모리를 할당하여 표현하면 메모리 낭비가 너무 심하다. 

### 범용 트리의 표현

- 각 노드에서 부모가 같은 노드(형제 노드)들을 왼쪽에서 오른쪽으로 연결을 한다.
- 첫번째 자식을 제외한 나머지 노드와의 연결을 삭제한다. 
- 노드의 구성은 요소, 첫번째 자식, 다음 형제 로 구성된다. 
```java
    public class TreeNode {
        public int data;
        public TreeNode firstChild;
        public TreeNode nextSibling;
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public TreeNode getFirstChild(){
            return firstChild;
        }
        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }
        public TreeNode getNextSibling(){
            return nextSibling;
        }
        public void setNextSibling(TreeNode nextSibling) {
            this.nextSibling = nextSibling;
        }
    }
```
- 어떤 범용 트리라도 이진 트리로 표현할 수 있기 때문에 실무에서는 이진 트리만 사용한다.
 

## 스레드 이진 트리 탐색

- 앞에서 전위, 중위, 후위, 이진 트리 탐색은 스택을 사용하고 레벨 순서 탐색은 큐를 보조 데이터 구조로 사용한다는 것을 보았다. 
- 스택, 큐 모두를 사용 하지 않는 새로운 탐색 방법을 알아본다. 그것은 바로 **스레드 이진 탐색** 혹은 스택/큐 없는 탐색이라고 부른다. 

### 일반적인 이진 트리 탐색의 문제점들 

- 스택이나 큐를 위해 필요한 저장 공간이 많이 소모된다. 
- 이진트리의 포인터 중 대부분이 null이다. n개의 노드를 가지면 n+1개의 null 포인터가 있고 이것은 메모리가 낭비되는 것이다.  
- 주어진 노드의 후임노드(전위, 중위, 후위 탐색시의 후임노드)를 찾기가 힘들다.

### 스레드 이진 트리를 사용하는 이유

- 위 문제를 해결하는 방법은 null 포인터에 뭔가 유용한 정보를 저장하는 것
- 스택/큐가 필요한 이유는 왼쪽 서브트리 처리가 끝난 뒤 오른쪽 서브 트리로 이동하기 위해 현재 위치를 저장하기 때문이다. 
- null 포인터에 이 정보를 저장 한 이진트리를 **스레드 이진트리** 라고 한다. 
- 왼쪽  null 포인터에 전임정보를 오른쪽 null 포인터에 후임정보를 담고 사용하는 포인터는 스레드이다. 

### 스레드 이진트리 구분하기

- 정보를 두 null 포인터에 모두 저장하는가, 한나만 저장하는가에 따라 구분된다. 
    1. 전임정보를 왼쪽 null 포인터에만 저장하는 이진트리를 **왼쪽 스레드 이진 트리** 라고 한다.
    2. 후임정보를 오른쪽 null 포인터에만 저장하는 이진트리를 **오른쪽 스레드 이진 트리** 라고 한다.
    3. 두 null 포인터 모두에 정보를 저정하는 이진트리를 **완전 스레드 이진 트리** 혹은 **스레드 이진 트리** 라고 한다.

> 이후에는 스레드 이진 트리만 다룸.  

### 스레드 이진 트리의 종류

- 전위 스레드 이진 트리 : 왼쪽 null 포인터에는 전위 전임 정보가 저장되고 오른쪽 null 포인터에는 전위 후임 정보가 저장 된다.
- 중위 스레드 이진 트리 : 왼쪽 null 포인터에는 중위 전임 정보가 저장되고 오른쪽 null 포인터에는 중위 후임 정보가 저장 된다.
- 후위 스레드 이진 트리 : 왼쪽 null 포인터에는 후위 전임 정보가 저장되고 오른쪽 null 포인터에는 후위 후임 정보가 저장 된다. 

> 각 사용법이 유사하므로, 중위 스레드 이진 트리만 이용하여 설명함. 

### 스레드 이진 트리의 구조

- 트리를 검사하는 프로그램이라면 일반적으로 왼쪽, 오른쪽 포인터와 스레드를 구분할 수 있어야 한다. 
- 각 노드에 두개의 항목을 추가로 넣는다. 
- Left(포인터) | LTag | data | RTag | Right(포인터) 이런 형태를 갖는다. 
```java
    public class ThreadedBinaryTreeNode {
        public ThreadedBinaryTreeNode left;
        public int LTag;
        public int RTag;
        public ThreadedBinaryTreeNode right;
        ...
    }
```

### 이진트리와 스레드 이진 트리의 구조 차이점

|              |일반적인 이진 트리  |스레드 이진 트리 |
|:------------ | :-------------  | :--------------------------- |
|ifLtag == 0   | NULL            | 왼쪽 포인터는 중위 전임 노들을 가리킴 |
|ifLtag == 1   | 왼쪽 포인터는 왼쪽 자식을 가리킴 | 왼쪽 포인터는 왼쪽 자식을 가리킴 |
|ifRtag == 0   | NULL            | 오른쪽 포인터는 중위 후임 노들을 가리킴 |  
|ifRtag == 1   | 오른쪽 포인터는 오른쪽 자식을 가리킴 | 오른쪽 포인터는 오른쪽 자식을 가리킴 |  

> 유사하게 전위/후위의 차이점도 정의할 수 있다. 

### 제일 왼쪽 포인터와 제일 오른쪽 포인터는 무엇을 가리켜야 하는가?

- 빈 트리에도 더미 노드를 설정하는 것이 좋다. (예를 들어 자기 자신)

### 중위 스레드 이진 트리에서 중위 후임 노드 찾기 

- 스택을 사용하지 않고 중위 후임노드를 찾으려 사용하는 노드를 P라고 하자. 
- P에서 오른쪽 서브 트리가 없다면 P의 오른쪽 자식 노드를 리턴한다. 만약 P에게 오른쪽 서브 트리가 있다면 그 노드의 왼쪽 서브 트리에 P를 포함하는
가장 가까운 노드의 왼쪽 자식 노드를 리턴한다. 

```java
     public ThreadedBinaryTreeNode InorderSuccessor(ThreadedBinaryTreeNode P){
        ThreadedBinaryTreeNode Position;
        if (P.RTag == 0) { //오른쪽 서브트리가 없다면 P의 오른쪽 자식노드를 반환 
            return P.getRight();
        } else {
            Position = P.getRight();
            while(Position.getLTag() == 1){
                Position = Position.getLeft();
            }
            return Position;
        }
     }
//     시간 복잡도 : O(n)
//     공간 복잡도 : O(1)
```
  
### 중위 스레드 이진 트리에서 중위 탐색하기

- 더미노드에서 시작해서 다시 더미 노드에 닿을 때까지 InorderSuccessor()를 호출하여 모든 노드를 방문 할 수 있다. 

```java
    public void InorderTraversal(ThreadedBinaryTreeNode root) {
        ThreadedBinaryTreeNode P = InorderSuccessor(root);
        while(P != root) {
            P = InorderSuccessor(P);
            System.out.println(P.getData());
        }
    }
// 다른 방법
    public void InorderTraversal(ThreadedBinaryTreeNode root) {
        ThreadedBinaryTreeNode P = root;
        while(1) {
            P = InorderSuccessor(P);
            if (P == root) return;
            System.out.println(P.getData());
        }
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
    
```

### 중위 스레드 이진 트리에서 전위 후임 노드찾기

- P에서 왼쪽 서브 트리가 있다면 P의 왼쪽 자식 노드를 리턴한다. P에게 왼쪽 서브 트리가 없다면 그 노드의 오른쪽 서브 트리에 P를 
포함하는 가장 가까운 노드의 오른쪽 자식 노드를 리턴한다.
```java
    public ThreadedBinaryTreeNode PreorderSuccessor(ThreadedBinaryTreeNode P) {
        ThreadedBinaryTreeNode Position;
        if (P.getTag() == 1) {
            return P.getLeft();
        } else {
            Position = P;
            while (Position.getRTag() == 0) {
                Position = Position.getRight();
            }
            return Position.getRight();
        }
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
    
```

### 중위 스레드 이진 트리에서 전위 탐색하기 

- 중위 탐색과 유사하게 더미 노드에서 시작해서 다음 더미 노드에 닿을 때까지 PreorderSuccessor()를 호출하여 모든 노드를 방문할 수 있다. 

```java
    public void PreorderTraversal(ThreadedBinaryTreeNode root) {
        ThreadedBinaryTreeNode P;
        P = PreorderSuccessor(root);
        while (P != root) {
            P = PreorderSuccessor(P);
            System.out.println(P.getData());
        }
    }

// 다른 방법 : 
    public void PreorderTraversal(ThreadedBinaryTreeNode root) {
        ThreadedBinaryTreeNode P;
        while(1) {
            P = PreorderSuccessor(P);
            if (P == root) {
                return;
            }
            System.out.println(P.getData());
        }
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
    
``` 

### 중위 스레드 이진 트리에 노드 삽입하기 

- P와 Q 노드가 있다. Q를 P의 오른쪽에 추가하려고 한다. 이 때 두가지 경우가 있다. 

    1. P 노드에 오른쪽 자식이 없으 경우 Q를 P에 추가하고 Q 노드의 왼쪽, 오른쪽 포인터만 바꾸면 된다. 
    2. P 노드에 오른쪽 자식 (R)이 있는 경우 R의 왼쪽 서브 트리를 탐색해서 제일 왼쪽 노드를 찾아 그 노드의(S) 왼쪽 포인터를 바꿔야 한다. 

```java
    public void ThreadedBinaryTreeNodeAdd(ThreadedBinaryTreeNode P){
        ThreadedBinaryTreeNode Q;
        ThreadedBinaryTreeNode temp;
        Q.setRight(P.getRight());
        Q.setLeft(P);
        Q.setLTage(0);
        Q.setRight(Q);
        Q.setRTag(1);
        if (Q.getRTag() ==1) { //두번째 경우
            Temp = Q.getRight();
            while (Temp.getLTag())
                Temp = Temp.getLeft();
            Temp.setLeft(Q);
        }
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
    
```    

## 이진 검색 트리 (BST: Binary Search Tree)

### 왜 이진 검색 트리인가?

- 이 트리의 주 용도는 검색이다.
- 이전 트리들은 데이터에 제한을 두지 않아 검색을 하려면 왼쪽 오른쪽 서브트리를 모두 검사해야하므로 최악의 경우 복잡도는 O(n)이다. 
- 이진 검색 트리는 데이터에 제한을 둔다. 최악의 경우 복잡도는 O(logn) 이다. 

### 이진 검색 트리의 속성 

- 왼쪽 서브 트리의 노드 값들은 노드(뿌리)의 키 값보다 작은 값들로 구성되어야 한다.
- 오른쪽 서브 트리의 값들은 노드(뿌리)의 키 값보다 큰 값으로 구성되어야 한다. 
- 왼쪽, 오른쪽 서브 트리 모두 이진 검색 트리여야 한다. 
  
### 이진 검색 트리의 연산

- 주 연산 
    1. 이진 검색 트리의 항목 찾기, 최소값 찾기, 최대 값 찾기
    2. 이진 검색 트리에 새 항목 삽입하기
    3. 이진 검색 트리로부터 항목 삭제하기
    
- 보조 연산
    1. k번째 작은 항목 찾기
    2. 이진 검색 트리의 항목 정렬하기 등등 
    
### 이진 검색 트리에 대한 주요 사항

- root 데이터가 항상 왼쪽 서브 트리 , 오른쪽 서브 트리 사이에 있기 때문에 중위 탐색을 하면 정렬된 리스트가 만들어 진다. 
- 이진 검색 트리를 이용해 문제를 풀 때 대부분 왼쪽 서브트리를 먼저 처리하고 root 데이터를 처리 후 오른쪽 서브트리를 처리한다. 문제에 따라 
root만 바뀌고 첫번째, 세번째 단계는 변하지 않는다. 
- 값에 따라 왼쪽, 오른쪽 둘 중 하나만 검색한다. 

### 이진 검색 트리에서 항목 찾기 
  
- 찾는 데이터가 root 면 현재 노드를 리턴, 현재 root의 값보다 작으면 왼쪽 서브트리를 탐색, root 값보다 크면 오른쪽 서브트리를 탐색해서 찾는다. 
- 찾는 데이터가 없으면 NULL을 리턴. 

```java
     public BinarySearchTreeNode Find(BinarySearchTreeNode root, int data) {
        if (root == null) return null;
        if (data < root.getData()) {
            return (Find(root.getLeft(), data)));
        } else if (data > root.getData()) {
            return (Find(root.getRight(), data);
        }
        return root;
     }
     
//     시간 복잡도 : 최악의 경우 (BST가 경사 트리일 때) O(n)
//     공간 복잡도 : 재귀적 스택 때문에 O(n)
     
// 비 재귀적 방법
    public BinarySearchTreeNode Find(BinarySearchTreeNode root, int data) {
        if (root == null) return null;
        while(root != null) {
            if (data == root.getData()) {
                return root;
            } else if (data > root.getData()) {
                root = root.getRight();
            } else {
                root = root.getLeft();
            }
        }
        return null;
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
 
```  

### 이진 검색 트리에서 최소 항목 찾기 

- BST에서 최소값은 자식을 갖지 않은 제일 왼쪽 노드이다. 

```java
    public BinarySearchTreeNode FindMin(BinarySearhTreeNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getLeft() == null) {
                return root;
            } else {
                return (FindMin(root.getLeft());
            }
        }
    }
    
    //시간 복잡도 : 최악의 경우 (BST가 경사 트리일 때) O(n)
    //공간 복잡도 : 재귀적 스택 때문에 O(n)
    
// 비 재귀적 방법
    public BinarySearchTreeNode FindMin(BinarySearchTreeNode root) {
        if (root == null) return null;
        else {
            while(root.getLeft() != null){
                root = root.getLeft();
            }
            return root;
        }
    }
    
    //시간 복잡도 : O(n)
    //공간 복잡도 : O(1)
    
```

### 이진 검색 트리에서 최대 항목 찾기 

- BST에서 최소값은 자식을 갖지 않은 제일 오른쪽 노드이다. 

```java
    public BinarySearchTreeNode FindMax(BinarySearchTreeNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getRight() == null) {
                return root;
            } else {
                return (FindMax(root.getRight());
            }
        }
    }
    
 //   시간 복잡도 : 최악의 경우 (BST가 경사 트리일 때) O(n)
 //   공간 복잡도 : 재귀적 스택 때문에 O(n)

// 비 재귀적 방법
    public BinarySearchTreeNode FindMax(BinarySearchTreeNode root) {
        if (root == null) return null;
        while (root != root.getRight()) {
            root = root.getRight();
        }
        return root;
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : O(1)
    
```

### 중위 전임 노드와 후임 노드는 어디에 있는가 ?

- X가 두 개의 자식 노드를 가진 다면 중위 전임 노드는 왼쪽 서브 트리의 최대값이고 중위 후임 노든 오른쪽 서브 트리의 최소 값이다. 
- 왼쪽 자식 노드가 없다면 중위 전임 노드는 첫 번째 왼쪽 조상 노드이다.

### 이진 검색 트리에 항목 삽입하기 

1. 데이터를 삽입할 위치를 찾는다.
2. 위치를 찾는 동안 데이터가 존재하면 무시하고 나오면 된다. 
3. 그렇지 않으면 탐색한 경로의 마지막 위치에 데이터를 추가 한다. 

```java
    public BinarySearchTreeNode Insert(BinarySearchTreeNode root, int data){
        if (root == null) {
            root = new BinarySearchTreeNode();
            if (root == null) {
                System.out.println("Memory Error");
                return null;
            } else {
                root.setData(data);
                root.setLeft(null);
                root.setRight(null);
            }
        } else {
            if (data < root.getData()) {
                root.setLeft(Insert(root.getLeft(), data));
            } else if (data > root.getData()) {
                root.setRight(Insert(root.getRight(), data));
            }
            return root;
        }
    }
    
//    시간 복잡도 : O(n)
//    공간 복잡도 : 재귀적 스택은 O(n) 반복접 방법은 O(1)
```

### 이진 검색 트리에서 항목 삭제하기 

- 먼저 삭제할 노드가 leaf인지 아닌지 구분해야 한다. 
- 삭제할 항목이 잎 노드라면 NULL을 부모 노드에게 리턴한다. 
- 

  
  
  
  
  
  
  
  
  
  
