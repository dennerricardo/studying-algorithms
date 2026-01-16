package dev.algorithms;

public class ArrayExample {
    public static void main(String[] args){
        // Declaring and initializing an array of Integers
        int [] numbers = {10,20,30,40,50};

        // Accessing elements by index (O(1) time complexity)
        System.out.println("First Element: "+ numbers[0]);

        // Modifying an element
        numbers[2] = 100 ;

        // Iterating through the array
        System.out.println("Array elements: ");
        for(int num : numbers){
            System.out.println(num + " ");

        }

    }

}
