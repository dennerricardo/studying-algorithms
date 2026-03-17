package dev.graphs;

import java.util.*;

public class BreadthFirstSearch {

    static Map<String, List<String>> graph = new LinkedHashMap<>();

    public static void addEdge(String from, String to ){
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    public static List<String> breadthFirstSearch(String start){
        List<String> visitOrder  = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        System.out.println("=== Breadth First Search starting from: " + start + " ===");

        while (!queue.isEmpty()){
            String current = queue.poll();
            visitOrder.add(current);
            System.out.println("Visiting : " + current);

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    System.out.println(" -> Enqueued: " + neighbor);
                }
            }
        }

        return visitOrder;
    }

    public static List<String> shortestPath(String start, String end){
        if(start.equals(end)) {
            return List.of(start);
        }
        Map<String, String> parentMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()){
            String current = queue.poll();

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    parentMap.put(neighbor,current);
                    queue.offer(neighbor);

                    if(neighbor.equals(end)){

                        List<String> path = new ArrayList<>();
                        String node = end;
                        while (node != null){
                            path.add(0, node);
                            node = parentMap.get(node);
                        }
                        return path ;
                    }
                }
            }
        }

        return new ArrayList<>();
    }

    public static void printGraph(){
        System.out.println("\n === Graph (Adjacency List) ===");
        for (Map.Entry<String,List<String>> entry : graph.entrySet()){
            System.out.println(entry.getKey()+ "->"+ entry.getValue());
        }
        System.out.println();
    }

}
