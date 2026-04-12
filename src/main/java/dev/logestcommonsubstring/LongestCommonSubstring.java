package dev.logestcommonsubstring;

public class LongestCommonSubstring {
    public static String longestCommonSubString(String a, String b){
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0 ;
        int endIdxA = 0 ;

        for(int i = 1; i <= n; i ++){
            char ca = a.charAt(i -1);
            for(int j = 1 ; j <= m; j++){
                if(ca == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1 ] + 1 ;
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        endIdxA = i ;
                    }
                }else {
                    dp[i][j] = 0 ;
                }
            }
        }
        return a.substring(endIdxA - maxLen, endIdxA) ;
    }

    public static void printTable(String a, String b, int[][] dp){
        System.out.print("    ");
        System.out.print("   ");
        for(int j = 0; j < b.length(); j++){
            System.out.print("  " + b.charAt(j));
        }
        System.out.println();

        for (int i = 0; i <= a.length(); i++){
            if(i == 0){
                System.out.println("  ");
            }else {
                System.out.println(" " + a.charAt(i - 1 ));
            }
            for(int j = 0 ; j <= b.length(); j++){
                System.out.printf("%3d", dp[i][j]);
            }
            System.out.println();
        }
    }
}
