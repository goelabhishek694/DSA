import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int m=scn.nextInt();

        int ans=bnsKTrans(n,m,arr);
        System.out.println(ans);
    }

    // public static int bnsKTrans(int n, int m, int[] arr){
    //     int[][] dp=new int[m+1][n];
    //     for(int t=1;t<=m;t++){
    //         for(int p=1;p<arr.length;p++){
    //             int maxProfitFromTminus1=Integer.MIN_VALUE;
    //             for(int i=0;i<p;i++){
    //                 maxProfitFromTminus1=Math.max(maxProfitFromTminus1,(arr[p]-arr[i])+dp[t-1][i]);
    //             }

    //             dp[t][p]=Math.max(dp[t][p-1],maxProfitFromTminus1);
    //         }
    //     }

    //     return dp[m][n-1];

    // }

//optimized 0(n^2)
    public static int bnsKTrans(int n, int m, int[] arr){
        int[][] dp=new int[m+1][n];
        for(int t=1;t<=m;t++){
            int max=dp[t-1][0]-arr[0];
            for(int p=1;p<arr.length;p++){
                max=Math.max(max,dp[t-1][p-1]-arr[p-1]);

                dp[t][p]=Math.max(dp[t][p-1],max+arr[p]);
            }
        }

        return dp[m][n-1];

    }

}


//leetcode 188

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<1) return 0;
        int[][] dp=new int[k+1][prices.length];
        
        for(int t=1;t<=k;t++){
            int max=Integer.MIN_VALUE;
            for(int p=1;p<prices.length;p++){
                max=Math.max(max,dp[t-1][p-1]-prices[p-1]);
                dp[t][p]=Math.max(dp[t][p-1],max+prices[p]);
            }
        }
        
        return dp[k][prices.length-1];
    }
}