import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        System.out.println(mazePath(arr));
    }

    public static int mazePath(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];

        for(int row=n-1;row>=0;row--){
            for(int col=m-1;col>=0;col--){
                if(row==n-1 && col==m-1){
                    dp[row][col]=arr[row][col];
                    continue;
                }
                int minCost=Integer.MAX_VALUE;
                if(col+1<arr[0].length){
                    minCost=Math.min(minCost,dp[row][col+1]);
                }
                if(row+1<arr.length){
                    minCost=Math.min(minCost,dp[row+1][col]);
                }

                dp[row][col]=minCost+arr[row][col];

            }
        }

        return dp[0][0];
    }

}

// leetcode 64. Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp=new int[grid.length][grid[0].length];

        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j==grid[0].length-1){
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int min=Integer.MAX_VALUE;
                if(j+1<grid[0].length){
                    min=Math.min(min,dp[i][j+1]);
                }
                if(i+1<grid.length){
                    min=Math.min(min,dp[i+1][j]);
                }

                dp[i][j]=min+arr[i][j];
            }
        }

        return dp[0][0];
    }
}
