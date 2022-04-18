import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
		//write your code here
        int[][] dp=new int[arr.length][arr[0].length];
        int maxSquareSubmatrix=1;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr[0].length;j>=0;j--;){
                if(arr[i][j]==0) continue;
                else if(arr[i][j]==1 && (i==arr.length-1 || j==arr[0].length-1)){
                    dp[i][j]=1;
                    
                }
                else{
                    int minSquare=Integer.MAX_VALUE;
                    if(j+1<arr[0].length){
                        minSquare=Math.min(minSquare,arr[i][j+1]);
                    }
                    if(i+1<arr.length){
                        minSquare=Math.min(minSquare,arr[i+1][j]);
                    }
                    if(i+1<arr.length && j+1<arr[0].length){
                        minSquare=Math.min(minSquare,arr[i+1][j+1]);
                    }
                }
                dp[i][j]=minSquare;
                maxSquareSubmatrix=Math.max(maxSquareSubmatrix,dp[i][j]);
            }
            
        }

		return maxSquareSubmatrix;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}