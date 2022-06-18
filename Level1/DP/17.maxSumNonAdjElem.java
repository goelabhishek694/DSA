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
        int ans=maxSumNonAdjEle(arr);
        System.out.println(ans);
    }

    public static int maxSumNonAdjEle(int[] arr){
        // int[] dp=new int[arr.length];
        int oldIncl=0;
        int oldExcl=0;
        for(int i=0;i<arr.length;i++){
            int newIncl=oldExcl+arr[i];
            int newExcl=Math.max(oldIncl,oldExcl);

            oldIncl=newIncl;
            oldExcl=newExcl;
        }

        return Math.max(oldExcl,oldIncl);
    }
}