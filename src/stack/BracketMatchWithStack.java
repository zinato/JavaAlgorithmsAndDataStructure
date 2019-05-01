package stack;


import java.util.Scanner;

class Stack {
    private char[] stack;
    private int top;
    public Stack(int size){
        stack = new char[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        if(top == -1) return true;
        else return false;
    }
    public void push(char data){
        stack[++top] = data;

    }
    public char pop() {
//        if (isEmpty()) {
//            System.out.println("Stack is Empty");
//        } else {
            return stack[top--];
//        }
    }

}

public class BracketMatchWithStack {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Stack stack = new Stack(input.length());
        System.out.println("input : " + input);



        int loopCount = 0;
        while (loopCount < input.length()) {
            boolean isInCorrect = false;
            char openPair;
            char ch = input.charAt(loopCount);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;

                case ')':
                case '}':
                case ']':
                    if( stack.isEmpty()) {
                        isInCorrect = true;
                        break;
                    } else {
                        openPair = stack.pop();
                        if( (openPair == ')') && (ch != '(') ||
                            (openPair == '}') && (ch != '{') ||
                            (openPair == ']') && (ch != '[') ) {
                            isInCorrect = false;
                        } else {
                           break;
                        }
                    }
                    if(isInCorrect) {
                        break;
                    }
                    break;

            }
            loopCount++;
        }

        if(stack.isEmpty()){
            System.out.println("통과");
        } else {
            System.out.println("에러");
        }


    }

}
