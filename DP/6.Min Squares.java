import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		//write your code here
        int count=0;
		
		int[] dp=new int[n+1];
		dp[0]=0;
		for(int i=1;i<=n;i++){
			int num=1;
			int minCount=Integer.MAX_VALUE;
			while(num*num<=i){
				int sub=i-num*num;
				minCount=Math.min(minCount,dp[sub]+1);
				num++;
			}
			dp[i]=minCount;

		}

		return dp[n];

		
	}
    

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

    

	
}