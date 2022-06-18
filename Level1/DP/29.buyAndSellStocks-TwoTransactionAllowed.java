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
        System.out.println(bnsTwoTrans(n,arr));
    }

    public static int bnsTwoTrans(int n, int[] arr){
        int[] dp1=new int[n];
        dp1[0]=0;
        int maxProfitSoldTodayOrEarlier=0;
        int min=arr[0];
        // int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]-min>maxProfitSoldTodayOrEarlier){
                maxProfitSoldTodayOrEarlier=arr[i]-min;
            }
            dp1[i]=maxProfitSoldTodayOrEarlier;
        }

        int[] dp2=new int[n];
        dp2[n-1]=0;
        int maxProfitSoldTodayOrLater=0;
        int max=arr[n-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
            }
            if(max-arr[i]>maxProfitSoldTodayOrLater){
                maxProfitSoldTodayOrLater=max-arr[i];
            }
            dp2[i]=maxProfitSoldTodayOrLater;
        }

        

        int maxProfit=0;
        for(int i=0;i<n;i++){
            // System.out.println(dp1[i]+" "+ dp2[i]);
            maxProfit=Math.max(maxProfit,dp1[i]+dp2[i]);
        }

        return maxProfit;
    }

}

// leetcode 129

class Solution {
    public int maxProfit(int[] prices) {
        int[] dp1=new int[prices.length];
        int maxProfitIfSoldTodayOrEarlier=Integer.MIN_VALUE;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            maxProfitIfSoldTodayOrEarlier=Math.max(maxProfitIfSoldTodayOrEarlier,prices[i]-min);
            dp1[i]=maxProfitIfSoldTodayOrEarlier;
        }
        
        int[] dp2=new int[prices.length];
        int maxProfitIfSoldTodayOrLater=Integer.MIN_VALUE;
        int max=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(max<prices[i]){
                max=prices[i];
            }
            maxProfitIfSoldTodayOrLater=Math.max(maxProfitIfSoldTodayOrLater,max-prices[i]);
            dp2[i]=maxProfitIfSoldTodayOrLater;
        }
        
        int maxProfit=0;
        for(int i=0;i<dp1.length;i++){
            maxProfit=Math.max(maxProfit,dp1[i]+dp2[i]);
        }
        
        return maxProfit;
    }
}