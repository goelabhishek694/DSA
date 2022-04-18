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
        System.out.println(unboundedKnapsack(n,value,weights,cap));

    }

    public static int unboundedKnapsack(int n, int[] value, int[] weights, int cap){
        int[] dp=new int[cap+1];
        for(int i=0;i<weights.length;i++){
            for(int j=0;j<dp.length;j++){
                if(j==0) continue;
                // int maxVal=Integer.MIN_VALUE;
                if(j-weights[i]>=0){
                    dp[i][j]=dp[j-weights[i]]+value[i]);
                }

            }

        }
        return dp[cap];
    }
}