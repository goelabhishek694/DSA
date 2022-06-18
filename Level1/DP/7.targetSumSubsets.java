import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int tar=scn.nextInt();

        System.out.println(targetSumSubset(arr,tar));
    }

    // RECURSION
    // public static boolean targetSumSubset(int[] arr, int tar, int idx){
    //     if(idx==arr.length){
    //         if(tar==0){
    //             return true;
    //         }
    //         return false;
    //     }

    //     boolean res=false;
    //     if(tar-arr[idx]>=0){
    //         res=res||targetSumSubset(arr,tar-arr[idx],idx+1);
    //     }
    //     res=res||targetSumSubset(arr,tar,idx+1);

    //     return res;
    // }

    public static boolean targetSumSubset(int[] arr, int tar){
        boolean[][] dp=new boolean[arr.length+1][tar+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    dp[i][j]=true;
                    continue;
                }
                if(i==0){
                    dp[i][j]=false;
                    continue; 
                }
                boolean res=false;
                //batting krega
                if(j-arr[i-1]>=0){
                    res=res||dp[i-1][j-arr[i-1]];
                }
                //batting nhi krega
                res=res||dp[i-1][j];

                dp[i][j]=res;
            }
        }

        return dp[arr.length][tar];
    }
}

// GFG
// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp=new boolean[N+1][sum+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                    continue;
                }
                if(i==0){
                    dp[i][j]=false;
                    continue;
                }

                boolean res=false;
                if(j-arr[i-1]>=0){
                    res=res||dp[i-1][j-arr[i-1]];
                }
                res=res||dp[i-1][j];
                dp[i][j]=res;
            }
        }
        return dp[N][sum];
        
    }
}