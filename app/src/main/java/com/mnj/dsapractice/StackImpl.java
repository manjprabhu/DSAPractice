package com.mnj.dsapractice;

public class StackImpl {

    int top = -1;
    int maxSize = 10;
    int stack[] = new int[maxSize];

    void push(int data) {
        if (top == maxSize) {
            System.out.println("==>> Stack overflow");
            return;
        }
        top++;
        stack[top] = data;
    }

    void pop() {
        if (top == -1) {
            System.out.println("==>> Stack underflow");
            return;
        }
        System.out.println("==>> Poped element is : " + stack[top]);
        top--;
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
}
