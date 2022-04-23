import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        int[][] dp=new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(i==j || j==0){
                    dp[i][j]=1;
                    continue;
                }
                if(i<j) continue;

                dp[i][j]=dp[i-1][j]*(j+1) + dp[i-1][j-1];

            }
        }

        return dp[n][k];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}