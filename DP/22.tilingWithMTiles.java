import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int ans=mTiles(n,m);
        System.out.println(ans);
    }

    public static int mTiles(int n, int m){
        if(n<m) return 1;
        int[] dp=new int[n];
        for(int i=0;i<m-1;i++){
            dp[i]=1;
        }
        dp[m-1]=2;
        for(int i=m;i<n;i++){
            dp[i]=dp[i-1];

            if(i-m>=0){
                dp[i]+=dp[i-m];
            }
        }

        return dp[n-1];
    }
}