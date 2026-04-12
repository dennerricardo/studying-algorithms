package dev.knapsack;

public class BackpackMain {
    public static void main(String[] args) {
        Item[] items = {
                new Item("water", 2,10),
                new Item("book", 1,3),
                new Item("food", 2,9),
                new Item("sweater",  2 ,4),
                new Item("camera",  1, 6),
        };
        int capacity = 6;

        int n = items.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for(int i = 1; i <= n; i++){

            Item cur = items[i - 1];

            for (int w = 0; w <= capacity; w++){
                dp[i][w] = dp[i - 1][w];
                if(cur.getWeight() <= w){
                    int candidate = dp[i - 1][w - cur.getWeight()] +cur.getValue() ;
                    if(candidate > dp[i][w]){
                        dp[i][w] = candidate;
                    }
                }
            }
        }
        System.out.println("Maximum obtainable value: " + dp[n][capacity]);

        int w = capacity;
        System.out.println("Items to take:");
        for(int i = n; i > 0; i--){
            if(dp[i][w] != dp[i - 1][w]) {
                Item taken = items[i - 1];
                System.out.println("- " + taken.getName() +
                        " (weight=" + taken.getWeight() +
                        "kg, value=" + taken.getValue() + ")");
                w -= taken.getWeight();
            }
        }
    }
}
