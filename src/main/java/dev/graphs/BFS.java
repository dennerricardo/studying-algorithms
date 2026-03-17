package dev.graphs;

import java.util.List;

public class BFS {
    public static void main(String[] args) {
        BreadthFirstSearch.addEdge("Alice", "Bob");
        BreadthFirstSearch.addEdge("Alice", "Carol");
        BreadthFirstSearch.addEdge("Bob", "Dave");
        BreadthFirstSearch.addEdge("Bob", "Eve");
        BreadthFirstSearch.addEdge("Carol", "Frank");
        BreadthFirstSearch.addEdge("Frank", "Grace");
        BreadthFirstSearch.addEdge("Denner", "Pamela");
        BreadthFirstSearch.addEdge("Pamela", "Grace");

        BreadthFirstSearch.printGraph();
        List<String> order = BreadthFirstSearch.breadthFirstSearch("Alice");

        System.out.println("\n === Shortest Paths ===");
        System.out.println("Alice -> Grace" + BreadthFirstSearch.shortestPath("Alice","Grace"));
        System.out.println("Pamela -> Bob" + BreadthFirstSearch.shortestPath("Pamela","Bob"));


    }
}
