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
        while (!s.isEmpty()) {
            System.out.println("==>> Before Stack content is : " + s.pop());
        }
        reverse(s);

    }
}
