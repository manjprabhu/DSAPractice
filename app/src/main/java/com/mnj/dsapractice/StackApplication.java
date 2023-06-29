package com.mnj.dsapractice;

import java.util.Stack;

public class StackApplication {

    Stack<Integer> s = new Stack<Integer>();

    void deleteCenterElementFromStack() {
        s.push(5);
        s.push(4);
        s.push(1);
        s.push(7);
        deleteMiddleElement(s, s.size());
    }

    void solve(Stack<Integer> stack, int count, int stackSize) {
        if (count == stackSize / 2) {
            stack.pop();
            return;
        }

        int num = stack.peek();
        stack.pop();
        solve(stack, count + 1, stackSize);
        stack.push(num);
    }

    private void deleteMiddleElement(Stack<Integer> stack, int stackSize) {
        int count = 0;
        solve(stack, count, stackSize);
    }

    void display() {
        while (!s.isEmpty()) {
            System.out.println("==>> Stack content is : " + s.pop());
        }
    }

//    ********************************* Insert at the bottom of stack ***********************************************

    private void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int num = stack.peek();
        stack.pop();

        //recursive call
        insert(stack, element);
        stack.push(num);
    }

    void insertElementAtBottom() {
        s.push(7);
        s.push(1);
        s.push(4);
        s.push(5);
        int element = 9;
        insert(s, element);
    }

    //    ********************************* Reverse  Stack ***********************************************

    private void reverse(Stack<Integer> stack) {
        //Base condition
        if (stack.isEmpty()) {
            return;
        }

        int num = stack.peek();
        stack.pop();

        reverse(stack);
        //insert at bottom
        insertBottom(stack, num);
    }

    void insertBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int num = stack.peek();
        stack.pop();

        insertBottom(stack, element);
        stack.push(num);
    }

    void revereStack() {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(1);
        s.push(4);
        s.push(5);

        reverse(s);
    }

    //    ********************************* Sort the  Stack ***********************************************

    void sortStack() {
        Stack<Integer> s = new Stack<>();
        s.push(7);
        s.push(1);
        s.push(4);
        s.push(5);
        sort(s);
    }

    void sort(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int num = stack.peek();
        stack.pop();

        sort(stack);
        insertInSortedWay(stack, num);
    }

    private void insertInSortedWay(Stack<Integer> stack, int element) {

        //If stack is empty or top element is smaller than current element , push the element in stack.
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
            return;
        }

        //save the top element and then pop the stack.
        int num = stack.peek();
        stack.pop();

        insertInSortedWay(stack, element);
        stack.push(num);
    }


    //    ********************************* Redundant brackets ***********************************************

    //bracket is redundant if there is no operator between opening and closing bracket
    boolean isRedundant() {
        String exp = "(x + (a+b))";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            //If current element is opening bracket or an operator push to the stack
            if (ch == '(' || ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                stack.push(ch);
            } else {
                //if the current element is closing bracket then check if there is any operator in between closing and opening bracket
                //so run the while loop
                if (ch == ')') {
                    boolean isRedundant = true;
                    while (stack.peek() != '(') {
                        char top = stack.peek();
                        if (top == '-' || top == '+' || top == '*' || top == '/') {
                            isRedundant = false;
                        }
                        stack.pop();
                    }
                    if (isRedundant)
                        return true;
                    stack.pop(); // to pop the '('
                }

            }
        }
        return false;
    }
}
