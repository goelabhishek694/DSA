import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);

        String str1=scn.nextLine();
        String str2=scn.nextLine();

        int n=str1.length();
        int m=str2.length();

        int[][] dp=new int[n+1][m+1];

        for(int i=n;i>=0;i--){
            for(int j=m;j>=0;j--){
                if(i==n || j==m){
                    dp[i][j]=0;
                    continue;
                }
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }

}