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

        System.out.println(coinChangePermutation(arr,tar));
    }

    public static int coinChangePermutation(int[] arr, int tar){
        int[] dp=new int[tar+1];
        dp[0]=1;
        for(int target=1;target<=tar;target++){
            for(int i=0;i<arr.length;i++){
                int coin=arr[i];
            
                if(target-coin>=0){
                    dp[target]+=dp[target-coin];
                }
            }
        }

        return dp[tar];
    }
}