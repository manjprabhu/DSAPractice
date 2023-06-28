package com.mnj.dsapractice;

public class GetMinimumFromStack {

    int top = -1;
    int maxSize = 10;

    int minTop = -1;

    int[] stack = new int[maxSize];
    int[] minStack = new int[maxSize];

    void push(int data) {
        if (top == maxSize) {
            System.out.println("==>> Stack overflow");
            return;
        }

        top = top + 1;
        stack[top] = data;

        pushToMinStackImprovised(data);
    }

    void pushToMinStack(int data) {

        if (minTop == maxSize) {
            System.out.println("==>> Stack overflow");
            return;
        } else if (minTop == -1) {
            minTop = minTop + 1;
            minStack[minTop] = data;
        } else if (minStack[minTop] < data) {
            int ele = minStack[minTop];
            minTop = minTop + 1;
            minStack[minTop] = ele;
        } else {
            minTop = minTop + 1;
            minStack[minTop] = data;
        }
    }

    void pushToMinStackImprovised(int data) {
        if (minTop == maxSize) {
            System.out.println("==>> Stack overflow");
            return;
        } else if (minTop == -1) {
            minTop = minTop + 1;
            minStack[minTop] = data;
        } else if (minStack[minTop] >= data) {
            minTop = minTop + 1;
            minStack[minTop] = data;
        }
    }

    void getMinimum() {
        if (minTop == -1) {
            System.out.println("==>> Stack underflow");
            return;
        }
        System.out.println("==>> Current minimum is :" + minStack[minTop]);
    }

    void display() {
        if (top == -1) {
            System.out.println("==>> Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("==>> Element is :" + stack[i]);
        }
    }


    void minStackDisplay() {
        if (minTop == -1) {
            System.out.println("==>> Min Stack is empty");
            return;
        }
        for (int i = minTop; i >= 0; i--) {
            System.out.println("==>> MinStack Element is :" + minStack[i]);
        }
    }

}
