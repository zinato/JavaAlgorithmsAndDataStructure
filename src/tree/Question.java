package tree;

import queue.LLQueue;
import stack.LLStack;

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
    public void printPaths() {
        int[] path = new int[256];
        printPaths(node, path, 0);
    }
    private void printPaths(BinaryTreeNode node, int[] path, int pathLen) {

    }





} // end of Question class

