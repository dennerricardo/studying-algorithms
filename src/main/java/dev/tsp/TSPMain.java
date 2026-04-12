package dev.tsp;

import java.util.List;

import static dev.tsp.TSP.*;

public class TSPMain {
    public static void main(String[] args) {
        List<TSP.City> cities = List.of(
                new TSP.City("João Pessoa",    -46.63, -23.55),
                new TSP.City("Rio de Janeiro", -43.17, -22.90),
                new TSP.City("Brasília",     -47.93, -15.78),
                new TSP.City("Salvador",     -38.50, -12.97),
                new TSP.City("Fortaleza",    -38.54,  -3.72),
                new TSP.City("Manaus",       -60.02,  -3.10),
                new TSP.City("Curitiba",     -49.27, -25.43),
                new TSP.City("Recife",       -34.88,  -8.05)
        );

        System.out.println("=== Nearest Neighbour (Greedy) ===");
        List<TSP.City> greedyTour = nearestNeighbour(cities, 0);
        greedyTour.forEach(c -> System.out.println("  -> " + c.name()));
        System.out.printf("  Total distance: %.2f units%n%n", tourLength(greedyTour));

        System.out.println("=== Held-Karp (Exact DP) ===");
        List<TSP.City> exactTour = heldKarp(cities);
        exactTour.forEach(c -> System.out.println("  -> " + c.name()));
        System.out.printf("  Total distance: %.2f units%n", tourLength(exactTour));
    }
}
