package com.mnj.dsapractice;

import java.util.Stack;

public class PalindromeCheck {

    void isPalindrome() {

        String str = "abaXbaba";
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (str.charAt(i) != 'X') {
            stack.push(str.charAt(i));
            i++;
        }
        i++; // skip the element X;

        while (i != str.length()) {
            if (stack.isEmpty() || str.charAt(i) != stack.pop()) {
                System.out.println("==>> String is not palindrome");
                return;
            }
            i++;
        }

        System.out.println("==>> String is palindrome");

    }
}
