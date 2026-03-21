package dev.dijkstra;

import java.util.List;
import java.util.Map;

import static dev.dijkstra.Dijkstra.*;

public class DijkstraMain {

    public static void main(String[] args) {

        Map<String,Map<String, Integer>> graph = buildGraph();
        Map<String, Integer> costs = buildCosts(graph);
        Map<String,String> parents = buildParents(graph);

        System.out.println("=== Dijkstra's Algorithm (Grokking Algorithms) ===\n");
        System.out.println("Initial costs : " + costs);
        System.out.println("Initial parents: " + parents);
        System.out.println();


        Dijkstra djktr = new Dijkstra();
        djktr.dijkstra(graph,costs,parents);

        System.out.println("Final costs : " + costs);
        System.out.println("Final parents: " + parents);
        System.out.println();

        int shortestCost = costs.get("END");
        List<String> path = reconstructPath(parents,"END");

        System.out.println("Shortest cost to END: " + shortestCost);
        System.out.println("Shortest path      : " + String.join(" -> ", path));
    }
}
