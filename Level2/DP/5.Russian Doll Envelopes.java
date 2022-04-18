import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=scn.nextInt();
            arr[i][1]=scn.nextInt();
        }
        
        Arrays.sort(arr,(int[] a, int[] b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i][1]>arr[j][1]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            count=Math.max(count,dp[i]);
        }

        System.out.println(count);
    }

}