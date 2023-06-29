package com.mnj.dsapractice;

import java.util.Stack;

public class StackApplication {

    Stack<Integer> s = new Stack<Integer>();

    void deleteCenterElementFromStack() {
        s.push(10);
        s.push(12);
        s.push(11);
        s.push(14);
        s.push(15);
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
}
