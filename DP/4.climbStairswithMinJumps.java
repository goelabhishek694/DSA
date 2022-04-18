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
        
        System.out.println(csmj(arr,n));

    }

    public static int csmj(int[] arr, int n){
        
        Integer[] dp=new Integer[n+1];
        // Arrays.fill(dp,Integer.MAX_VALUE);

        for(int i=n;i>=0;i--){
            if(i==n){
                dp[i]=0;
                continue;
            }
            int minJump=Integer.MAX_VALUE;
            for(int j=1;j<=arr[i];j++){
                if(i+j<=n){
                    // System.out.println("hello"+i+" "+j);
                    if(dp[i+j]==null) continue;
                    if(dp[i+j]+1<minJump){
                        minJump=dp[i+j]+1;
                        dp[i]=minJump;
                    }
                }
            }
        }

        return dp[0];
    }
}