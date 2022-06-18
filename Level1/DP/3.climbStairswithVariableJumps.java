import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        // int[] dp=new int[n+1];
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        // System.out.println(csvj(arr,0));
        System.out.println(csvj(arr,n));

    }
    //RECURSION 

    // public static int csvj(int[] arr, int idx){
    //     if(idx==arr.length) return 1;
    //     if(arr[idx]==0) return 0;
    //     int ways=0;
    //     for(int j=1;j<=arr[idx];j++){
    //         if(idx+j<=arr.length){
    //             ways+=csvj(arr,idx+j);
    //         }
    //     }

    //     return ways;
    // }

    // DP

    public static int csvj(int[] arr, int n){
        int[] dp=new int[n+1];

        for(int i=n;i>=0;i--){
            if(i==n) {
                dp[i]=1;
                continue;
            }
            for(int j=1;j<=arr[i];j++){
                if(i+j<=n){
                    dp[i]+=dp[i+j];
                }
            }
        }

        return dp[0];
    }

}