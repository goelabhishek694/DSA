import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] value=new int[n];
        for(int i=0;i<n;i++){
            value[i]=scn.nextInt();
        }

        int[] weights=new int[n];
        for(int i=0;i<n;i++){
            weights[i]=scn.nextInt();
        }

        int cap=scn.nextInt();
        System.out.println(zeroOneKnapsack(n,value,weights,cap));

    }

    public static int zeroOneKnapsack(int n, int[]value, int[] weights, int cap){
        int[][] dp=new int[value.length+1][cap+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                // if(i==0 || j==0) continue;
                int maxVal=Integer.MIN_VALUE;
                if(j-weights[i-1]>=0){
                    maxVal=Math.max(maxVal,dp[i-1][j-weights[i-1]]+value[i-1]);
                }
                maxVal=Math.max(maxVal,dp[i-1][j]);
                dp[i][j]=maxVal;

            }
        }
        return dp[value.length][cap];
    }

}