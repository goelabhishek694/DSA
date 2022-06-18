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

        goldMine(arr);
        
    }

    public static void goldMine(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];

        for(int col=m-1;col>=0;col--){
            for(int row=n-1;row>=0;row--){
                if(col==m-1){
                    dp[row][col]=arr[row][col];
                    continue;
                }
                int maxGold=Integer.MIN_VALUE;
                if(row-1>=0 && col+1<m){
                    maxGold=Math.max(maxGold,dp[row-1][col+1]);
                }
                if(col+1<m){
                    maxGold=Math.max(maxGold,dp[row][col+1]);
                }
                if(row+1<n && col+1<m){
                    maxGold=Math.max(maxGold,dp[row+1][col+1]);
                    
                }
                dp[row][col]=maxGold+arr[row][col];
            }
        }

        int maxGold=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            maxGold=Math.max(maxGold,dp[i][0]);
        }
        System.out.println(maxGold);
    }

}

// gfg
// https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/
class Solution{
    static int maxGold(int n, int m, int arr[][])
    {
        // code here
        int[][]dp=new int[n][m];
        for(int c=m-1;c>=0;c--){
            for(int r=0;r<n;r++){
                if(c==m-1){
                    dp[r][c]=arr[r][c];
                    continue;
                }
                int maxGold=Integer.MIN_VALUE;
                if(c+1<m){
                    if(r-1>=0){
                        maxGold=Math.max(maxGold,dp[r-1][c+1]);
                    }
                    if(r>=0){
                        maxGold=Math.max(maxGold,dp[r][c+1]);
                    }
                    if(r+1<n){
                        maxGold=Math.max(maxGold,dp[r+1][c+1]);
                    }
                }
                
                dp[r][c]=maxGold+arr[r][c];
            }
        }
        int maxGoldMined=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxGoldMined=Math.max(maxGoldMined,dp[i][0]);
        }
        
        return maxGoldMined;
    }
}