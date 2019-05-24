package tree;

import queue.LLQueue;
import stack.LLStack;

import java.util.Stack;

public class Question {

    //00. 노드의 개수를 구하는 알고리즘을 구하여라
    public int countOfNode(BinaryTreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        } else {
            count = 1 + countOfNode(root.getLeft()) + countOfNode(root.getRight());
        }
        return count;
    }

    //01. 이진 트리의 항목 중에 최대값을 찾는 알고리즘을 구하라
    /*
        풀이방법 : 왼쪽 서브트리에서 가장 큰 값을 찾고 오른쪽 서브트리에서 가장 큰 값을 찾아 뿌리노드의 데이터와 비교해서
        최대값을 찾는다.
     */
    public int FindMax(BinaryTreeNode root) {
        int max = Integer.MIN_VALUE; //자바에서는 Integer.MIN_VALUE가 int형 최소값
        int root_val, left, right = 0;
        if (root != null) {
            root_val = root.getData();
            left = FindMax(root.getLeft());
            right = FindMax(root.getRight());
            if (left > right)
                max = left;
            else max = right;
            if (root_val > max)
                max = root_val;
        }
        return max;
    }

    //02. 재귀 없이 이진 트리의 항목 중에 최대 값을 찾는 알고리즘을 구하라.
    /*
      정답: 레벨순서 탐색을 사용한다.
           시간복잡도: O(n)
           공간복잡도: O(n)
     */
    public int FindMaxUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        int max = Integer.MIN_VALUE;
        LLQueue Q = new LLQueue();
        Q.enQueue(root.getData());
        while(!Q.isEmpty()){
            temp.setData(Q.deQueue());
            if (temp.getData() > max) {
                max = temp.getData();
            }
            if (temp.getLeft()) {
                Q.enQueue(temp.getLeft().getData());
            }
            if (temp.getRight()) {
                Q.enQueue(temp.getRight().getData());
            }
        }
        Q.deleteQueue(); //LLQueue에서 구현되지 않은 함수이기 때문에 에러가 발생함
        return max;
    } //에러가 발생함 타입이 잘 안맞는듯 함. 나중에 수정해야함

    //03. 이진 트리의 항목을 검색하는 알고리즘을 구하라.
    /*
        이진트리에서 구하는 데이터가 있는 노드가 발견되면 참을 리턴함.
        재귀적으로 트리 아래로 내려가면서 각 노드의 데이터와 비교해서 왼쪽이나 오른쪽을 선택한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public boolean FindInBinaryTreeUsingRecursion(BinaryTreeNode root, int data) {
        boolean temp;
        //트리가 비었을 경우 데이터가 없으므로 false를 리턴한다.
        if (root == null) {
            return false;
        } else if (data == root.getData()) {
            return true;
        } else {
            temp = FindInBinaryTreeUsingRecursion(root.getLeft(), data);
            if (temp != true) {
                return temp;

            } else {
                return (FindInBinaryTreeUsingRecursion(root.getRight(), data));
            }
        }
    }

    //04. 재귀없이 이진 트리 안의 항목을 검색하는 알고리즘을 구하라.
    /*
        레벨 순서 탐색을 사용해서 풀 수 있다.
        데이터를 출력하는 대신에 노드 데이터가 찾고 있는 항목과 같은지 검사한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)

     */
    public boolean SearchUsingLevelOrder(BinaryTreeNode root, int data) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        if (!root) return false;
        Q.enQueue(root.getData());
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            //여기서 발견되었는지 확인
            if (data == root.getData())
                return true;
            if (temp.getLeft())
                Q.enQueue(temp.getLeft().getData());
            if (temp.getRight())
                Q.enQueue(temp.getRight());
        }
        Q.deleteQueue();
        return false;
    }

    //05. 이진 트리에 항목을 삽입하는 알고리즘을 구하라.
    /*
        시간복잡도 : O(n)
        공간복잡도 : O(n)
     */
    public void InsertBinaryTree(BinaryTreeNode root, int data) {
        LLQueue Q = new LLQueue();
        BinaryTreeNode temp = null;
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setLeft(null);
        newNode.setRight(null);
        if(newNode == null) {
            System.out.println("Memory Error");
            return;
        }
        if(root == null) {
            root = newNode;
            return;
        }
        Q.enQueue(root.getData());
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            if (temp.getLeft()) {
                Q.enQueue(temp.getLeft().getData());
            } else {
                temp.setLeft(newNode);
                Q.deleteQueue();
                return;
            }
            if (temp.getRight()) {
                Q.enQueue(temp.getRight().getData());
            } else {
                temp.setRight(newNode);
                Q.deleteQueue();
                return;
            }
        }
        Q.deleteQueue();

    }

    //06. 이진트리의 크기를 구하는 알고리즘을 구하라.
    /*
        왼쪽과 오른쪽 서브 트리의 크기를 재귀적으로 구해 1을 더해서 (현재 노드의) 부모노두에게 리턴한다.

        시간복잡도 : O(n)
        공간복잡도 : O(n)
     */
    public int SizeOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return (SizeOfBinaryTree(root.getLeft()) + 1 + SizeOfBinaryTree(root.getRight()));
        }
    }

    //07. 재귀없이 이진트리의 크기를 구하는 알고리즘을 구하라
    /*
        이것 역시 레벨순서 탐색을 사용하면 된다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)

     */
    public int SizeOfUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            count++;
            if (temp.getLeft())
                Q.enQueue(temp.getLeft());
            if (temp.getRight())
                Q.enQueue(temp.getRight());
        }
        Q.deleteQueue();
        return count;
    }

    //08.트리를 삭제하는 알고리즘을 구하라
    /*
        트리를 삭제하려면 노드를 모두 탐색하면서 하나씩 삭제해야한다.
        후위 탐색은 트리를 정렬할 필요 없이 바로 삭제가 가능하다.
        나머지 중위, 전위 탐색은 공간 복잡도를 추가로 필요하다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public void DeleteBinaryTree(BinaryTreeNode root) {
        if (root == null) return;
        //먼저 양쪽 서브 트리 모두 삭제
        DeleteBinaryTree(root.getLeft());
        DeleteBinaryTree(root.getRight());
        //서브 트리 삭제 후 현재 노드 삭제
        root = null; //자바에서는 가비지 컬렉터가 관리함.
    }


    //09. 레벨 순서 트리를 역순으로 출력하는 알고리즘을 만들어라.
    /*

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */


    public void LevelOrderTraversalInReverse(BinaryTreeNode root) {
        LLQueue Q = new LLQueue();
        LLStack S = new LLStack();
        BinaryTreeNode temp;
        if (root == null) return;
        Q.enQueue(root);
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            if (temp.getLeft())
                Q.enQueue(temp.getLeft());
            if (temp.getRight())
                Q.enQueue(temp.getRight());
            S.push(temp);
        }
        while (!S.isEmpty())
            System.out.println(S.pop());
    }

    //10. 이진 트리의 높이 (혹은 깊이)를 구하는 알고리즘을 구하라.
    /*
        왼쪽과 오른쪽 서브 트리의 높이를 재귀적으로 계산해서 두 자식 각각의 높이에 1을 더한 값중 최대 값을
        해당 노드의 높이로 할당.
        DFS와 유사.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */

    public int HeightBinaryTree(BinaryTreeNode root) {
        int leftHeight, rightHieght;
        if (root == null) return 0;
        else {
            //각 서브트리의 깊이를 계산한다.
            leftHeight = HeightBinaryTree(root.getLeft());
            rightHieght = HeightBinaryTree(root.getRight());
            if (leftHeight > rightHieght) {
                return (leftHeight + 1);
            } else {
                return (rightHieght + 1);
            }
        }
    }

    //11. 재귀 없이 높이를 구하는 알고리즘을 구하라.
    /*
        역시 레벨 순서 탐색을 사용한다.
        BFS(Breadth First Search: 넓이 우선 탐색)와 유사하다.
        높이의 끝은 null에 의해 검사된다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int FindHeightOfBinaryTree(BinaryTreeNode root) {
        int level = 1;
        LLQueue Q = new LLQueue();
        if (root == null) return 0;
        Q.enQueue(root);
        //첫번째 레벨의 끝
        Q.enQueue(null);
        while (!Q.isEmpty()) {
            root.setData(Q.deQueue());
            //현재 레벨 종료
            if (root == null) {
                //다음 레벨을 위한 마커 추가
                if(!Q.isEmpty())
                    Q.enQueue(null);
                    level++;
            } else {
                if(root.getLeft())
                    Q.enQueue(root.getLeft());
                if(root.getRight())
                    Q.enQueue(root.getRight());
            }
        }
        return level;
    }

    //12. 이진트리의 가장 깊은 노드를 찾는 알고리즘을 구하라.
    /*
        레벨 순서 탐색을 이용한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public BinaryTreeNode DeepestBinaryTree(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        if (root == null) return null;
        Q.enQueue(root);
        while(!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            if (temp.getLeft())
                Q.enQueue(temp.getLeft());
            if (temp.getRight())
                Q.enQueue(temp.getRight());
        }
        Q.deleteQueue();
        return temp;
    }

    //13. 트리로부터 항목을 삭제하는 알고리즘을 알아보자.
    /*
        1. 삭제 하려는 노드를 찾는다.
        2. 트리에서 가장 깊은 노드를 찾는다.
        3. 가장 깊은 노드의 데이터와 삭제할 노드의 데이터를 바꾼다.
        4. 가장 깊은 노드를 삭제한다.
     */

    //14. 재귀를 사용하지 않고 트리안의 잎 노드들의 개수를 구하는 알고리즘을 구하라.
    /*
        레벨 순서 탐색을 이용

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int NumberOfLeavesInBTUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        LLQueue Q = new LLQueue();
        int count = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            if (temp.getLeft() == null && temp.getRight() == null) //왼쪽 오른쪽 서브트리가 모드 null이면 그 노드는 leaf임.
                count++;
            else {
                if (temp.getLeft() != null)
                    Q.enQueue(temp.getLeft());
                if (temp.getRight() != null)
                    Q.enQueue(temp.getRight());
            }
        }
        Q.deleteQueue();
        return count;
    }

    //15. 재귀를 사용하지 않고 이진 트리 안의 포화 노드들의 개수를 구하는 알고리즘을 구하라.
    /*
        왼쪽 , 오른쪽 서브트리가 모두 null이 아니면 그 노드는 포화 노드이다.
        레벨 순서 탐색을 사용한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int NumberOfFullNodesInBTUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp = null;
        LLQueue Q = new LLQueue();
        int count = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while (!Q.isEmpty()) {
            if (root.getLeft() != null && root.getRight() != null) { //여기가 핵심!
                count++;
            } else {
                if (root.getLeft() != null) {
                    Q.enQueue(root.getLeft());
                }
                if (root.getRight() != null) {
                    Q.enQueue(root.getRight());
                }
            }
        }
        Q.deleteQueue();
        return count;
    }

    //16. 재귀를 사용하지 않고 이진 트리 안의 반포화 노드 (자식이 하나뿐인) 의 개수를 구하는 알고리즘을 구하라.
    /*
        레벨 순서 탐색을 사용한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */

    public int NumberOfHalfNodesInUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int count = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while(!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            if (root.getLeft() != null && root.getRight() == null ||
                root.getLeft() == null && root.getRight() != null) { //반포화 노드인지 검사하는 부분
                count++;
            }
            if (root.getLeft())
                Q.enQueue(root.getLeft());
            if (root.getRight())
                Q.enQueue(root.getRight());
        }
        Q.deleteQueue();
        return count;
    }

    //17. 주어진 두 개의 이진트리가 구조적으로 똑같다면 참을 리턴하는 함수를 만들어라.
    /*
        두 트리 모두 null 이면 true를 반환한다.
        두 트리 모두 null이 아니라면 현재 노드 데이터 비교, 재귀적으로 왼쪽, 오른쪽 서브트리를 차례대로 비교한 값을 리턴한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public boolean AreStructlySameTrees (BinaryTreeNode root1, BinaryTreeNode root2) {
        //둘 다 비었으면 -> 1
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        //둘다 비어있지 않을 경우 둘을 비교
        return (root1.getData() == root2.getData() &&
                AreStructlySameTrees(root1.getLeft(), root2.getLeft()) &&
                AreStructlySameTrees(root1.getRight() ,root2.getRight()));

    }


    //18. 이진 트리의 지름을 구하는 알고리즘을 구하라. 트리의 지름(너비)는 트리 안에서 두 잎 노드 사이의 길이가 가장 길 때의 노드의 개수이다.
    /*
        왼쪽 서브트리의 지름을 계산하고 으른쪽 서브트리의 지름을 재귀적으로 계산한다. 이 두 값 중에 최대 값에 현재 레벨(+1)을 더한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int DiameterOfTree(BinaryTreeNode root, int diameter) {
        int left, right;
        if (root == null) return 0;
        left = DiameterOfTree(root.getLeft(), diameter);
        right = DiameterOfTree(root.getRight(), diameter);
        if (left + right > diameter)
            diameter = left + right;
        return Math.max(left, right) + 1;

    }

    //19. 이진 트리에서 합이 제일 큰 레벨을 찾는 알고리즘을 구하라.
    /*
        레밸의 개수를 구하는 방식과 비슷하다.
        차이점은 합을 계속 저장해야한다는 것.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int FindLevelWithMaxSum(BinaryTreeNode root) {
        BinaryTreeNode temp;
        int level = 0, maxLevel = 0;
        LLQueue Q = new LLQueue();
        int currentSum = 0, maxSum = 0;
        if(root == null) return 0;
        Q.enQueue(root);
        Q.enQueue(null); //첫번째 레벨의 끝
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            //현재 레벨이 끝나면 합을 비교
            if (temp == null) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxLevel = level;
                }
                currentSum = 0;
                //다음 레벨의 끝을 나타내는 표지를 큐의 끝에 추가.
                if (!Q.isEmpty())
                    Q.enQueue(null);
                level++;
            } else {
                currentSum += temp.getData();
                if (temp.getLeft())
                    Q.enQueue(temp.getLeft());
                if (temp.getRight())
                    Q.enQueue(temp.getRight());
            }
        }
        return maxLevel;
    }

    //20. 주어진 이진 트리에 대해 뿌리에서 잎까지의 모든 경로를 출력하라.
     /*

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public void printPaths() {
        int[] path = new int[256];
        printPaths(node, path, 0);
    }
    private void printPaths(BinaryTreeNode node, int[] path, int pathLen) {
        if (node == null) return;
        //이 노드를 경로 배열에 추가
        path[pathLen] = node.getData();
        pathLen++;
        //leaf노드 이므로 여기까지 오는 경로를 출력한다.
        if (node.getLeft()==null && node.getRight() == null) {
            printArray(path, pathLen);
        } else { //아니라면 서브트리 모두 시도
            printPaths(node.getLeft(), path, pathLen);
            printPaths(node.getRight(), path, pathLen);

        }
    }
    private void printArray(int[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

    //21. 주어진 합을 가지는 경로가 존재하는지 검사하는 알고리즘을 구하라.
    /*
        자식 노드에 대해 재귀적으로 호출하기 전에 주어진 합으로부터 현재 노드의 값을 뺴서 트리 끝에 도달했을 때 이 합이 0이 되는지 검사한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public boolean hasPathSum(int sum) {
        return (hasPathSum(root, sum));
    }
    public boolean hasPathSum(BinaryTreeNode node, int sum) {
        //트리 끝에 도달했고 sum == 0 이면 참을 리턴
        if (node == null) {
            return (sum == 0);
        } else { //그렇지 않으면 양쪽 서브트리 모두 검사
            int subSum = sum - node.getData();
            return (hasPathSum(node.getLeft(), subSum) || hasPathSum(node.getRight(), subSum));
        }
    }

    //22. 이진트리의 모든 항목의 합을 구하라.
    /*
        재귀적으로 왼쪽 서브트리의 합 + 오른쪽 서브 트리의 합을 구한다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public int Add(BinaryTreeNode root) {
        if (root == null) return 0;
        else
            return (root.getData() + Add(root.getLeft()) + Add(root.getRight()));

    }

    //23. Q.22를 재귀 없이 풀어라.
    /*
        레벨순서탐색으로 해결 할 수 있다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n

     */
    public int SumOfUsingLevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        int sum = 0;
        if (root == null) return 0;
        Q.enQueue(root);
        while (!Q.isEmpty()) {
            temp.setData(Q.deQueue());
            sum += temp.getData();
            if (temp.getLeft() != null)
                Q.enQueue(root.getLeft());
            if (temp.getRight() != null)
                Q.enQueue(root.getRight());
        }
        Q.deleteQueue();
        return sum;
    }

    //24. 트리를 대칭형으로 변환시키는 알고리즘을 구하라. 트리의 대칭형은 모든 잎이 아닌 노드의 왼쪽, 오른쪽 자식들이 뒤바뀐 트리이다.
      /*
        각자의 서브트리를 바꾼다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n

     */
    public BinaryTreeNode MirrorOfBinaryTree(BinaryTreeNode root) {
        BinaryTreeNode temp;
        if (root != null) {
            MirrorOfBinaryTree(root.getLeft());
            MirrorOfBinaryTree(root.getRight());
            //서브트리를 서로 바꾼다.
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }

    //25. 주어진 두개의 트리에 대해 서로가 대칭형인지 아닌지 검사하는 알고리즘을 구하라.
    /*

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)

     */
    public boolean AreMirrors(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.getData() != root2.getData())
            return false;
        else return (AreMirrors(root1.getLeft(), root2.getRight()) && AreMirrors(root1.getRight(), root2.getLeft()));

    }

    //26. 중위, 전위 탐색 결과로부터 이진 트리를 만드는 알고리즘을 구하라.
    public BinaryTreeNode BuildBinaryTree(int inOrder[], int preOrder[], int inStrt, int inEnd) {
        int preIndex = 0;
        BinaryTreeNode newNode = new BinaryTreeNode();
        if(newNode == null) {
            System.out.println("Memory error");
            return null;
        }
        //전위 탐색으로부터 preIndex를 사용하여 현재노드를 선택한다.
        newNode.setData(preOrder[preIndex]);
        preIndex++;
        if (inStrt == inEnd) //이 노드에 자식이 없으면 리턴한다.
            return newNode;
        //그렇지 않으면 이 노드의 인덱스를 중위 탐색으로부터 찾는다.
        int inIndex = Search(inOrder, inStrt, inEnd, newNode.getData());
        //중위 탐색의 인덱스를 사용하여 왼쪽, 오른쪽 서브트리를 생성한다.
        newNode.setLeft(BuildBinaryTree(inOrder, preOrder, inStrt, inIndex - 1));
        newNode.setRight(BuildBinaryTree(inOrder, preOrder, inIndex+1, inEnd));
        return  newNode;
    }

    //27. 두개의 탐색순열이 주어진다면 이진트리를 유일하게 만들 수 있는가?
    /*
        둘 중 하나라도 중위 탐색이 있으면 가능하다.
        - 중위 와 전위
        - 중위 와 후위
        - 중위와 레벨 순서

        다음의 조합으로는 유일한 트리를 만들 수 없다.
        - 후위와 전위
        - 전위와 레벨 순서
        - 후위와 레벨 순서
        예를 들어 다음 트리 들에 대해 전위, 레벨 순서, 후위 탐색이 같다.
                A     A
               /       \
              B         B
       전위 탐색 = AB 후위탐색 = BA 레벨순서 탐색 = AB
       위의 세개개 주어져도 트리를 만들 수 없다.
     */

    //28. 이진트리에서 어떤 노드의 모든 조상들을 출력하는 알고리즘을 구하라.
    /*
        깊이 우선 탐색 (DFS)를 통해 재귀적으로 해결할 수 있다.

        시간 복잡도 : O(n)
        공간 복잡도 : 재귀를 위해 O(n)
     */
    public int PrintAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null) return 0;
        if (root.getLeft() == node || root.getRight() == node ||
            PrintAllAncestors(root.getLeft(), node) || PrintAllAncestors(root.getRight(), node)) {
            System.out.println(root.getData());
            return 1;
        }
        return 0;
    }

    //29. 이진트리에서 두 노드의 최소공통조상(LCA)를 찾는 알고리즘을 구하라.
    /*
        시간 복잡도 : O(n)
        공간 복잡도 : 재귀를 위해 O(n)
     */
    public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode alpha, BinaryTreeNode beta) {
        BinaryTreeNode left, right;
        if (root == null)
            return root;
        if (root == alpha || root == beta)
            return root;
        left = LCA(root.getLeft(), alpha, beta);
        right = LCA(root.getRight(), alpha, beta);
        if (left != null && right != null) return root;
        else return (left != null ? left : right);
    }

    //30. 지그재그 트리 탐색 : 이진 트리를 지그재그 순서로 탐색하는 알고리즘을 구하라.
    // 다음 예제의 트리 결과는 1 3 2 4 5 6 7 이다.
                 1
               /   \
              2     3
             / \   / \
            4   5  6  7
    /*
        두 개의 스택을 사용하면 쉽게 풀 수 있다.
        currentLevel과 nextLevel로 두 개의 스택을 정하고 현재 레벨의 순서를 추적하기 위한 변수가 하나 더 필요하다.
        currentLevel 스택으로부터 팝해서 노드의 값을 출력한다. 현재 레벨의 순서가 왼쪽에서 오른쪽일 때마다 노드의 왼쪽 자식, 그리고
        오른쪽 자식을 nextLevel 스택에 푸시한다. 다음 level에 노드들이 nextLevel에서 팝이 될 때 역순이된다.

        시간 복잡도 : O(n)
        공간 복잡도 : 두개의 스택을 위한 공간 = O(n) + O(n) = O(n)
     */

    //구현되지 않은 함수들이 많음 추후에 다시 구현
    public void ZigZagTraversal(BinaryTreeNode root) {
        BinaryTreeNode temp;
        boolean leftToRight = true;
        if (root == null) return;
        Stack currentLevel = new CreateStack(), nextLevel = new CreateStack();
        Push(currentLevel, root);
        while (!isEmpty(currentLevel)) {
            temp = Pop(currentLevel);
            if (temp != null) {
                System.out.println(temp.getData());
                if (leftToRight) {
                    if (temp.getLeft() != null)
                        Push(nextLevel, temp.getLeft());
                    if (temp.getRight() != null)
                        Push(nextLevel, temp.getRight());
                } else {
                    if (temp.getRight() != null)
                        Push(nextLevel, temp.getRight());
                    if (temp.getLeft() != null)
                        Push(nextLevel, temp.getLeft())
                }
            }
            if (isEmpty(currentLevel)) {
                leftToRight = false;
                swap(currentLevel, nextLevel);
            }
        }
    }

    //31. 이진트리의 세로 합을 구하라 .
    /*
        이해가 잘되지 않음 나중에 다시 풀이.
     */

    //32 n개의 노드를 가진 이진 트리의 종류는 최대 얼마인가
    /*
        2^n-n 개이다.
     */

    //33. 잎 노드 'L' 이라고 표시되고 중간노드는 'I'라고 표시되는 특별한 속성을 가진 트리가 주어진다. 또한 각 노드에는 0개 혹은 두개의 자식 노드가
    //있다. 이 트리에 대해 전위 탐색이 주어질 때 이 트리를 생성하라.
    //예 : 주어진 문자열 : I L I L L
    /*
        위 문자열로 트리를 만들면 아래와 같은 트리를 갖는다.
                I
               / \
              L   I
                 / \
                L   L
        1. 자식이 0 또는 2개 이므로 자식이 한개라도 있으면 그 형제 노드도 존재한다고 볼 수 있다.
        그러므로 서브 트리를 계산할 때 형제 서브트리도 계산해야 한다.

        2. 'L'을 만나면 잎 노드이므로 해당 서브트리를 거기서 멈출수 있다. 만약 'L'노드가 부모 노드의 오른쪽 자식이며 상위 계층으로 올라가서 계산할
        다음 서브트리를 찾아야 한다.

        시간 복잡도 : O(n)
     */
    public BinaryTreeNode BuildTreeFromPreOrder(char[] A, int i) {
        if (A == null) return null;
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setData(A[i]);
        newNode.setLeft(null);
        newNode.setRight(null);
        if (A[i] == 'L') { //잎 노드에 도달하면 return
            return newNode;
        }
        i = i + 1;// 왼쪽 서브트리를 만든다.
        newNode.setLeft(BuildTreeFromPreOrder(A, i));
        i = i + 1;// 오른쪽 서브트리를 만든다.
        newNode.setRight(BuildTreeFromPreOrder(A, i));
        return newNode;
    }

    //34. 이진 트리와 세 개의 포인터(left, right, nextSibling)가 주어졌을 때 초기값이 null인 nextSibling 포인터들의 값을 채우는
    //알고리즘을 구하라.
    /*
        간단한 큐를 사용하여 문제를 풀 수 있다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public void FillNextSiblings(BinaryTreeNode root) {
        LLQueue Q = new LLQueue();
        BinaryTreeNode temp = new BinaryTreeNode();
        if (root == null) return;
        Q.enQueue(root);
        Q.enQueue(null);//끝 부분 표시
        while (!Q.isEmpty()) {
            root.setData(Q.deQueue());
            //현재 레벨 완료
            if (root == null) {
                //다음 레벨을 위한 또 다른 라벨을 넣는다.
                if(!Q.isEmpty())
                    Q.enQueue(null);
            } else {
                temp.setNextSibling(Q.getFront());//함수가 아직 구현되어 있지 않음
                if (root.getLeft() != null)
                    Q.enQueue(root.getLeft());
                if (root.getRight() != null)
                    Q.enQueue(root.getRight());
            }
        }

    }

    //35. 문제 34를 푸는 다른 방법은?
    /*
        nextSiblings 포인터들을 다시 사용하는 것이다.
        left와 right 재귀 함수에게 보내기 전에 오른쪽 자식 노드의 nextSibling을 현재 노드의 nextSibling의 왼쪼 자식 노드에게 연결시킨다.
        현재 노드의 nextSibling 값이 채워줘야 한다.

        시간 복잡도 : O(n)
     */
    public void FillNextSiblings2(BinaryTreeNode root) {
        if (root == null) return;
        if (root.getLeft() != null)
            root.getLeft().nextSibling(root.getRight());
        if (root.getRight() != null)
            if (root.getNextSibling()) {
                root.getRight().setNextSibling(root.getNextSibling().getLeft());
            } else {
                root.getRight().setNextSibling(null);
            }
        FillNextSiblings2(root.getLeft());
        FillNextSiblings2(root.getRight());

    }
    //범용 트리 문제
    //36. 주어진 트리에 대해 모든 항목의 합을 구하는 알고리즘을 구하라.
    /*
       시간 복잡도 : O(n)
       공간 복잡도 : 스택 공간을 생각하지 않는다면 O(1). 그렇지 않으면 O(n).
     */
    public int FindSum(TreeNode root) {
        if (root == null) return 0;
        return (root.getData() + FindSum(root.getFirstChild()) + FindSum(root.getNextSibling()))
    }

    //37. 4항 트리에 대하여 100개의 노드를 가진 트리의 최대 높이를 구하라. 한개의 노드의 높이는 0으로 가정한다.
    /*
        한개의 노드만 4개의 자식을 가지고 나머지는 모두 한개의 자식을 갖도록 하면 된다.
        노드의 높이는 0부터 시작하므로 n-4 로 하면 답을 구할 수 있다.
        정답은 96.
     */

    //39. P[i]가 i번째 노드의 부모를 뜻하는 부모 배열 P가 주어졌을 때 트리의 높이 혹은 깊이를 구하는 알고리즘을 구하라.
    /*
        P 배열 : -1 , 0 , 1, 6, 6, 0, 0, 2, 7
        주어진 배열은 부모를 배열을 나타낸다. 각 노드에서 시작해서 -1에 닿을때까지 부모 노드로 계속 올라가면서 각 노드 중 최대 깊이를
        추적하면 된다.

        시간 복잡도 : O(n^2)
        공간 복잡도 : O(1)
     */
    public int FindDepthInGenericTree(int P[], int n) {
        int maxDepth = -1, currentDepth = -1, j;
        for (int i = 0; i < n; i++) {
            currentDepth = 0; j = i;
            while(P[j] != -1) {
                currentDepth++; j = P[j];
            }
            if (currentDepth > maxDepth)
                maxDepth = currentDepth;
        }
        return maxDepth;
    }

    //40. 범용트리의 주어진 노드의 형제 노드의 수를 구하라.
    /*
        시간 복잡도 : O(n)
        공간 복잡도 : O(1)
     */
    public int SiblingsCount(TreeNode current){
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNextSibling();
        }
        return count;
    }
    //41. 주어진 두개의 트리가 있을 때 이 두 트리가 동형인지 아닌가 구하는 알고리즘을 구하라.
    /*
        시간 복잡도 : O(n)
        공간 복잡도 : O(n)
     */
    public boolean IsIsomorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
                return false;
        return (IsIsomorphic(root1.getLeft(), root2.getLeft) && IsIsomorphic(root1.getRight(), root2.getRight()));
    }

    //42. 두 트리가 준-동형 트리인지 검사하는 알고리즘을 구하라.
    /*
        각 노드의 값은 중요하지 않고 형태만 중요하다.

        시간 복잡도 : O(n)
        공간 복잡도 : O(n)

     */
    public boolean QuasiIsomorphic(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        return (QuasiIsomorphic(root1.getLeft(), root2.getLeft()) &&
                QuasiIsomorphic(root1.getRight(), root2.getRight()) ||
                QuasiIsomorphic(root1.getRight(), root2.getLeft()) &&
                QuasiIsomorphic(root1.getRight(), root2.getLeft()));

    }

    //43. 범용 트리의 주어진 노드에 대해 자식 노드 개수를 세는 알고리즘을 구하라
    /*
        시간 복잡도 : O(n)
        공간 복잡도 : O(1)
     */
    public int ChildCount(TreeNode current) {
        int count = 0;
        current = current.getFirstChild();
        while (current != null) {
            count++;
            current = current.getNextSibling()
        }
        return count;
    }



} // end of Question class

