package dev.algorithms;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String>  stack = new Stack<>();

        // Push Elements

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println(stack);

        String removed = stack.pop();
        System.out.println(removed);


        System.out.println(stack);
    }
}
