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