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

        int ans=bnsWithCooldown(arr);
        System.out.println(ans);
    }

    public static int bnsWithCooldown(int[] arr){
        int obsp=-arr[0];
        int ossp=0;
        int ocsp=0;

        for(int i=1;i<arr.length;i++){
            int nbsp=0;
            int nssp=0;
            int ncsp=0;
            if(ocsp-arr[i]>obsp){
                nbsp=ocsp-arr[i];
            }
            else nbsp=obsp;

            if(arr[i]+obsp>ossp){
                nssp=arr[i]+obsp;
            }
            else nssp=ossp;

            ncsp=Math.max(ocsp,ossp);

            obsp=nbsp;
            ossp=nssp;
            ocsp=ncsp;
        }

        return ossp;
    }

}

// leetcode 309

class Solution {
    public int maxProfit(int[] prices) {
        int obsp=-prices[0];
        int ossp=0;
        int ocsp=0;
        
        for(int i=1;i<prices.length;i++){
            int nbsp=0;
            int nssp=0;
            int ncsp=0;
            
            nbsp=Math.max(obsp,ocsp-prices[i]);
            nssp=Math.max(ossp,prices[i]+obsp);
            ncsp=Math.max(ocsp,ossp);
            
            obsp=nbsp;
            ossp=nssp;
            ocsp=ncsp;
        }
        
        return ossp;
    }
}