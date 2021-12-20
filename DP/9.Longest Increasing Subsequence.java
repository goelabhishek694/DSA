import java.io.*;
import java.util.*;

public class Main {
    static int maxLength=Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        // int maxLength=1;
        // for(int i=0;i<n;i++){
        //     maxLength=Math.max(maxLength,lis(arr,i));
        // }
        // System.out.println(maxLength);
        System.out.println(lis(arr));
    }
    
    // public static int lis(int[] arr, int idx){
    //     if(idx==0){
    //         return 1;
    //     }
    //     int ans=1;
    //     for(int i=idx-1;i>=0;i--){
    //         if(arr[i]<=arr[idx]){
    //             ans = Math.max(ans,lis(arr,i)+1);
    //         }
    //     }
    //     return ans;
    // }

    public static int lis(int[] arr){
        int maxLength=1;
        int[] dp=new int[arr.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<=arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }

}