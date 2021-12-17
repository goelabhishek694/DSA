import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		//write your code here

        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<=6){
                dp[i]=i;
                continue;
            }
            for(int j=i-3;j>=0;j--){
                dp[i]=Math.max(dp[i],dp[j]*(i-j-1));
            }
            // System.out.println(dp[i]);
        }
        return dp[n];

	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}