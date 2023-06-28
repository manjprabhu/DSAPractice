package com.mnj.dsapractice;

public class BalancingOfSymbols {

    int top = -1;
    int maxSize = 10;

    char[] stack = new char[maxSize];

    boolean checkBalance() {

        String exp = "(A+B)+(C-D)";
        for (int i = 0; i < exp.length(); i++) {
            char ele = exp.charAt(i);
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
        System.out.println("==>> Push :"+data);
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
}
