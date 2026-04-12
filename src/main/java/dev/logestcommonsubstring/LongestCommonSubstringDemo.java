package dev.logestcommonsubstring;

import static dev.logestcommonsubstring.LongestCommonSubstring.longestCommonSubString;
import static dev.logestcommonsubstring.LongestCommonSubstring.printTable;

public class LongestCommonSubstringDemo {
    public static void main(String[] args) {
        String s1 = "blues";
        String s2 = "clues";

        int[][] dp = new int[s1.length() + 1][s2.length() +1 ];
        int maxLen = 0 ;
        int endIdxA = 0;

        for( int i = 1; i <= s1.length(); i++){
            char ca = s1.charAt( i - 1);
            for(int j = 1; j <= s2.length(); j++){
                if(ca == s2.charAt(j - 1)){
                    dp[i][j] = dp[i -1][j-1] +1 ;
                    if(dp[i][j]> maxLen){
                        maxLen = dp[i][j];
                        endIdxA = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        // Show the table
        System.out.println("DP table (rows = \"" + s1 + "\", cols = \"" + s2 + "\"):");
        printTable(s1, s2, dp);

        // Extract result
        String lcs = s1.substring(endIdxA - maxLen, endIdxA);
        System.out.println("\nLongest common substring: \"" + lcs + "\" (length = " + maxLen + ")");
    }
}
