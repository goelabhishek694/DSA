import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        int fee=scn.nextInt();

        int ans=bNSfeeInfiniteTran(arr,fee);
        System.out.println(ans);
    }

    public static int bNSfeeInfiniteTran(int[] arr, int fee){
        int bsp=-arr[0];
        int ssp=0;

        for(int i=1;i<arr.length;i++){
            int nbsp=Math.max(bsp,ssp-arr[i]);
            int nssp=Math.max(ssp,bsp+arr[i]-fee);

            bsp=nbsp;
            ssp=nssp;
        }

        return ssp;
    }
}

//leetcode 714

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp=-prices[0];
        int ossp=0;

        for(int i=1;i<prices.length;i++){
            int nbsp=Math.max(obsp,ossp-prices[i]);
            int nssp=Math.max(ossp,obsp+prices[i]-fee);

            obsp=nbsp;
            ossp=nssp;
        }

        return ossp;
    }
}