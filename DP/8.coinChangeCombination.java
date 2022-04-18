import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        int tar=scn.nextInt();

        System.out.println(coinChangeCombination(arr,tar));
    }

    // public static int coinChangeCombination(int[] arr, int tar){
    //     int[][] dp=new int[arr.length+1][tar+1];

    //     for(int i=0;i<dp.length;i++){
    //         for(int target=0;target<=tar;target++){
    //             if(target==0){
    //                 dp[i][target]=1;
    //                 continue;
    //             }
    //             if(i==0) continue;
    //             dp[i][target]+=dp[i-1][target];
    //             int coin=arr[i-1];
    //             if(target-coin>=0){
    //                 dp[i][target]+=dp[i][target-coin];
    //             }
    //         }
    //     }

    //     return dp[arr.length][tar];
    // }

    public static int coinChangeCombination(int[] arr, int tar){
        int[] dp=new int[tar+1];
        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            int coin=arr[i];
            for(int target=1;target<=tar;target++){
                if(target-coin>=0){
                    dp[target]+=dp[target-coin];
                }
            }
        }

        return dp[tar];
    }
}