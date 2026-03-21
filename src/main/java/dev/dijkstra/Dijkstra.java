package dev.dijkstra;

import java.util.*;

public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE ;

    public static Map<String, Map<String, Integer>> buildGraph(){
        Map<String, Map<String, Integer>> graph = new HashMap<>();


        //start [A,6]
        //start [B,2]
        Map<String, Integer> start = new HashMap<>();
        start.put("A",6) ;
        start.put("B",2) ;

        graph.put("START", start);

        //A[END,1]
        Map<String , Integer> a = new HashMap<>();
        a.put("END", 1);
        graph.put("A", a);

        //B[A,3]
        //B[FIM,5]
        Map<String , Integer> b = new HashMap<>();
        b.put("A", 3);
        b.put("END", 5);
        graph.put("B", b);

        //END[-]
        graph.put("END", new HashMap<>());

        return graph;
    }


    //
    public static Map<String, Integer> buildCosts(Map<String, Map<String, Integer>> graph){
        Map<String,Integer> costs = new HashMap<>();
        costs. putAll(graph.get("START"));

        for(String node : graph.keySet()){
            if(!node.equals("START") && !costs.containsKey(node)){
                costs.put(node, INF);
            }
        }
        return costs;
    }

    public static Map<String, String> buildParents(Map<String, Map<String, Integer>> graph){
        Map<String, String> parents  = new HashMap<>();
        for(String neighbor : graph.get("START").keySet()){
            parents.put(neighbor,"START");
        }
        return parents;
    }
    public String lowestCostNode(Map<String,Integer> costs, Set<String> processed ){
        String lowestNode = null ;
        int lowestCost = INF;

        for(Map.Entry<String, Integer> entry: costs.entrySet()){
            String node = entry.getKey();
            int cost = entry.getValue();

            if(cost < lowestCost && !processed.contains(node)){
                lowestCost = cost;
                lowestNode = node ;
            }
        }
        return lowestNode;
    }

    public Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph,
                                         Map<String, Integer> costs,
                                         Map<String, String> parents ) {
        Set<String> processed = new HashSet<>();

        String node = lowestCostNode(costs, processed);

        while (node != null ){
            int costToNode = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);

            for(Map.Entry<String, Integer> entry : neighbors.entrySet()){
                String neighbor = entry.getKey();
                int edgeWeight = entry.getValue();
                int newCost = costToNode + edgeWeight;
                if (!costs.containsKey(neighbors) || newCost < costs.get(neighbor)){
                    costs.put(neighbor,newCost);
                    parents.put(neighbor,node);
                }
            }
            processed.add(node);
            node = lowestCostNode(costs, processed);
        }
        return  costs;
    }

    public static List<String> reconstructPath(Map<String, String> parents, String target){
        LinkedList<String> path = new LinkedList<>();
        String current = target;

        while (current != null) {
            path.addFirst(current);
            current = parents.get(current);
        }
        if (!path.getFirst().equals("START")){
            path.addFirst(("START"));
        }
        return path;
    }

}
