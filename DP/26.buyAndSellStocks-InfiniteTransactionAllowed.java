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
        int ans=bNsInfTrans(arr);
        System.out.println(ans);
    }

    public static int bNsInfTrans(int[] arr){
        int sell=arr[0];
        int buy=arr[0];
        int profit=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                profit+=sell-buy;
                buy=sell=arr[i];
            }
            else if(arr[i]>sell){
                sell=arr[i];
            }
        }

        if(buy!=sell) profit+=sell-buy;

        return profit;
        
    }

}