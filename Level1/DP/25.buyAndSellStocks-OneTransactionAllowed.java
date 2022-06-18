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

        int ans=bNsOneTrans(arr);
        System.out.println(ans);
    }

    public static int bNsOneTrans(int[] arr){
        int buy=Integer.MAX_VALUE;
        int sell=0;
        int profit=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<buy){
                buy=arr[i];
            }
            else{
                sell=arr[i];
                profit=Math.max(profit,sell-buy);
            }
        }
        return profit;
    }

}