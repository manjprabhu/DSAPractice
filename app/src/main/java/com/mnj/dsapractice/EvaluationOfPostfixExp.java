package com.mnj.dsapractice;

import java.util.Stack;

public class EvaluationOfPostfixExp {

    Stack<Integer> stack = new Stack<>();
    int top = -1;
    int maxSize = 100;

    void push(int data) {
        System.out.println("==>> Push data:" + data);
        stack.push(data);
    }

    int pop() {
        return stack.pop();
    }

    void evaluatePostfixExpression() {
//        String exp = "123*+5-";
        String exp = "234*+823^/-";

        //infix = a + b * c -d /e ^ f

        //prefix = -+a*bc/d^ef

        //postfix = abc*+def/^-

        //a =2, b =3,c =4,d =8,e =2,f =3

        for (int i = 0; i < exp.length(); i++) {
            char ele = exp.charAt(i);

            if (Character.isDigit(ele)) {
                push(ele - '0');
            } else {
                int op1 = pop();
                int op2 = pop();
                int result;

                System.out.println("==>> op1 :" + op1 + " op2 :" + op2 + " Ele :" + ele);

                switch (ele) {
                    case '+': {
                        result = op2 + op1;
                        push(result);
                        break;
                    }
                    case '-': {
                        result = op2 - op1;
                        push(result);
                        break;
                    }
                    case '*': {
                        result = op2 * op1;
                        push(result);
                        break;
                    }
                    case '/': {
                        result = op2 / op1;
                        push(result);
                        break;
                    }
                    case '^': {
                        result = (int) Math.pow(op2, op1);
                        System.out.println("==>> power result:" + result);
                        push(result);
                        break;
                    }
                }

            }

        }
    }

    void evaluatePrefixExpression() {
        String exp = "-+2*34/8^23";

        //prefix = -+a*bc/d^ef

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ele = exp.charAt(i);

            if (Character.isDigit(ele)) {
                push(ele - '0');
            } else {

                int op1 = pop();
                int op2 = pop();

                int result;
                switch (ele) {
                    case '+': {
                        result = op1 + op2;
                        push(result);
                        break;
                    }
                    case '-': {
                        result = op1 - op2;
                        push(result);
                        break;
                    }
                    case '*': {
                        result = op1 * op2;
                        push(result);
                        break;
                    }
                    case '/': {
                        result = op1 / op2;
                        push(result);
                        break;
                    }
                    case '^': {
                        result = (int) Math.pow(op1, op2);
                        System.out.println("==>> power result:" + result);
                        push(result);
                        break;
                    }
                }
            }
        }
    }

    void display() {
        System.out.println("==>> Result of evaluation is : " + stack.pop());
    }

}
