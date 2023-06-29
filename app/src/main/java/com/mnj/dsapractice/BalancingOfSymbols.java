package com.mnj.dsapractice;

import java.util.Stack;

public class BalancingOfSymbols {

    int top = -1;
    int maxSize = 10;

    char[] stack = new char[maxSize];

    boolean checkBalance() {
        String exp = "(A+B)+(C-D)";
        for (int i = 0; i < exp.length(); i++) {
            char ele = exp.charAt(i);

            //if opening bracket push
            if (ele == '(' || ele == '{' || ele == '[') {
                push(ele);
                continue;
            }

            if (top == -1) {
                System.out.println("==>> Error");
                return false;
            }
            char check;

            switch (ele) {
                case ')': {
                    check = pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                }
                case '}': {
                    check = pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                }
                case ']': {
                    check = pop();
                    if (check == '{' || check == '(')
                        return false;
                    break;
                }

            }
        }
        return (top == -1);
    }

    void push(char data) {
        System.out.println("==>> Push :" + data);
        if (top == maxSize) {
            System.out.println("==>> Stack overflow");
            return;
        }
        top = top + 1;
        stack[top] = data;
    }

    char pop() {
        if (top == -1) {
            System.out.println("==>> Stack underflow");
            return '0';
        }
        char ele = stack[top];
        top--;
        return ele;
    }


    // another way to check balancing using Stack class

    boolean checkBalancing() {
        Stack<Character> stack = new Stack<>();

        String exp = "[({}){}[]]";

        for (int i = 0; i < exp.length(); i++) {
            char ele = exp.charAt(i);
            System.out.println("==>>  1 Element is :" + ele);

            if (ele == '(' || ele == '{' || ele == '[') {
                stack.push(ele);
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    System.out.println("==>> Peek Element is :" + top);
                    System.out.println("==>>  Element is :" + ele);
                    if ((ele == ')' && top == '(') || (ele == '}' && top == '{') || (ele == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
