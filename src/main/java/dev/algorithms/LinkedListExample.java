package dev.algorithms;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Pineapple");
        fruits.add("14");

        // Adding to the beginning or end (very efficient)
        fruits.addFirst("Mango");
        fruits.addLast("Orange");

        System.out.println("LinkedList elements: " + fruits);

        // Removing an element
        fruits.remove("Apple");

        // Iterating through the list
        System.out.println("LinkedList elements: " + fruits);

        // Accessing an element (O(n) time complexity)
        System.out.println("Elements at index 2: " + fruits.get(2));

    }
}
