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
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
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
```
   void PreOrder(BinaryTreeNode root){
    if (root != null) {
        System.out.println(root.getData());
        PreOrder(root.getLeft());
        PreOrder(root.getRight());
    }
   }
   시간 복잡도 :O(n)
   시간 복잡도 :O(n)
```
### 비재귀적 전위 탐색

- 비재귀적 전위 탐색에서는 왼쪽 서브 트리 탐색을 끝내면 오른쪽 서브 트리로 가기 위해 현재 노드를 기억하는 스택이 필요하다.
    1. 현재 노드를 처리한 뒤 왼쪽 서브 트리로 가기 전에 현재 노드를 스택에 저장한다. 
    2. 왼쪽 서브 트리 처리가 끝난 뒤 항목을 팝해서 오른쪽 서브 트리로 이동한다. 
    3. 1,2 과정을 스택이 비지 않는 동안 계속한다. 

```
    void PreOrderNonRecursive(BinaryTreeNode root){
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
    시간 복잡도: O(n)
    공간 복잡도: O(n)
```

### 중위 탐색

- 왼쪽 서브 트리를 중위 탐색으로 탐색한다.
- 뿌리노드를 방문한다.
- 오른쪽 서브트리를 중위 탐색으로 탐색한다.

```
    void InOrder(BinaryTreeNode root){
        if (root != null) {
            InOrder(root.getLeft());
            System.out.println(root.getData());
            InOrder(root.getRight());
        }
    }
    시간 복잡도 : O(n)
    공간 복잡도 : O(n)
``` 

### 비재귀적 중위 탐색
- 비재귀적 중위 탐색은 비재귀적 전위탐색과 비슷하다.
- 차이점은 왼쪽 서브 트리로 가기전에 노드를 처리하는 대신에 pop한 뒤 왼쪽 서브 트리 처리가 끝난 뒤 노드를 처리하는 것이다.
```
    void InOrderNonRecursive(BinaryTreeNode root){
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
    시간 복잡도 : O(n)
    공간 복잡도 : O(n)
```
### 후위 탐색

- 왼쪽 서브 트리를 후위 탐색으로 탐색한다.
- 오른쪽 서브 트리를 후위 탐색으로 탐색한다.
- 뿌리 노드를 방문한다. 
```
    void PostOrder(BinaryTreeNode root){
        if (root) {
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
    시간 복잡도 : O(n)
    공간 복잡도 : O(n)
```   

### 비재귀적 후위 탐색

- 전위, 중위 탐색과 달리 두번 탐색하는 노드가 발생함. 
- 두번째 방문에만 처리가 되어야 함.
- 스택으로부터 항목을 pop한 뒤 이 항목과 스택의 최상위 항목의 오른쪽이 같은지 검사하여 왼쪽 서브트리를 끝내고 온 것인지 오른쪽 서브트리를
끝내고 온 것인지 구분할 수 있다. 
- 이 둘이 같다면 왼쪽 서브트리와 오른쪽 서브트리 처리를 마친 것이다. 스택을 한번 더 pop한 뒤 데이터를 출력한다.

```
   void PostOrderNonRecursive(BinaryTreeNode root){
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
   시간 복잡도 : O(n)
   공간 복잡도 : O(n)
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

```
    void LevelOrder(BinaryTreeNode root) {
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
    시간 복잡도 : O(n)
    공간 복잡도 : O(n) //최악의 경우 마지막 레벨의 모든 항목이 순차적으로 큐에 있을 수 있기 때문에
```  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
