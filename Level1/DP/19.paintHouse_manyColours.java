import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        int[][] arr=new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        // int ans=paintHouseManyColours(arr);
        int ans=paintHouseManyColoursOptimized(arr);

        System.out.println(ans);
    }

    public static int paintHouseManyColours(int[][] arr){
        int[][] dp=new int[arr.length][arr[0].length];
        for(int i=0;i<arr[0].length;i++){
            dp[0][i]=arr[0][i];
        }
        for(int house=1;house<arr.length;house++){
            for(int color=0;color<arr[0].length;color++){
                int minCost=Integer.MAX_VALUE;

                for(int i=0;i<dp[0].length;i++){
                    if(i==color) continue; // cant apply same colour continously 
                    if(dp[house-1][i]<minCost){
                        minCost=dp[house-1][i];
                    }
                }

                dp[house][color]=minCost+arr[house][color];
            }
        }


        int minCostToPaint=Integer.MAX_VALUE;
        for(int i=0;i<dp[0].length;i++){
            minCostToPaint=Math.min(minCostToPaint,dp[dp.length-1][i]);
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return minCostToPaint;
    }

    public static int paintHouseManyColoursOptimized(int[][] arr){
        int[][] dp=new int[arr.length][arr[0].length];
        int least1=Integer.MAX_VALUE;
        int least2=Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++){
            dp[0][i]=arr[0][i];
            if(dp[0][i]<least1){
                least2=least1;
                least1=dp[0][i];
            }
            else if(dp[0][i]<least2){
                least2=dp[0][i];
            }
        }

        for(int house=1;house<arr.length;house++){
            int nleast1=Integer.MAX_VALUE;
            int nleast2=Integer.MAX_VALUE;
            for(int color=0;color<arr[0].length;color++){
                if(dp[house-1][color]!=least1){
                    dp[house][color]=least1+arr[house][color];
                }
                else{
                    dp[house][color]=least2+arr[house][color];
                }

                if(dp[house][color]<nleast1){
                    nleast2=nleast1;
                    nleast1=dp[house][color];
                }
                else if(dp[house][color]<nleast2){
                    nleast2=dp[house][color];
                }
            }

            least1=nleast1;
            least2=nleast2;
        }


        // int minCostToPaint=Integer.MAX_VALUE;
        // for(int i=0;i<dp[0].length;i++){
        //     minCostToPaint=Math.min(minCostToPaint,dp[dp.length-1][i]);
        // }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return least1;
    }
}

//leetcode 265

class Solution {
    public int minCostII(int[][] costs) {
        int n=costs.length;
        int k=costs[0].length;

        int[][] dp=new int[n][k];

        for(int i=0;i<k;i++){
            dp[0][i]=costs[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<k;j++){
                int minCostColor=Integer.MAX_VALUE;
                for(int c=0;c<k;c++){
                    if(c==j) continue;
                    minCostColor=Math.min(minCostColor,dp[i-1][c]);
                }
                dp[i][j]=minCostColor+costs[i][j];
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }

        return ans;
        
    }
}

//optimized 

class Solution {
    public int minCostII(int[][] costs) {
        int n=costs.length;
        int k=costs[0].length;

        int[][] dp=new int[n][k];
        int least=Integer.MAX_VALUE;
        int sleast=Integer.MAX_VALUE;

        for(int i=0;i<k;i++){
            dp[0][i]=costs[0][i];

            if(costs[0][i]<least){
                sleast=least;
                least=costs[0][i];
            }
            else if(costs[0][i]<sleast){
                sleast=costs[0][i];
            }
        }

        

        for(int i=1;i<n;i++){
            int nleast1=Integer.MAX_VALUE;
            int nleast2=Integer.MAX_VALUE;

            for(int j=0;j<k;j++){
                int minCostColor=Integer.MAX_VALUE;
                if(dp[i-1][j]!=least){
                    dp[i][j]=least+costs[i][j];
                }
                else{
                    dp[i][j]=sleast+costs[i][j];
                }

                if(dp[i][j]<nleast1){
                    nleast2=nleast1;
                    nleast1=dp[i][j];
                }

                else if(dp[i][j]<nleast2){
                    nleast2=dp[i][j];
                }
            }

            least=nleast1;
            sleast=nleast2;
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }

        return ans;
        
    }
}