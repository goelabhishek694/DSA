import java.io.*;
import java.util.*;

public class Main {
    static int maxLength=Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }

        int maxLength=1;
        for(int i=0;i<n;i++){
            maxLength=Math.max(maxLength,lis(arr,i));
        }
        System.out.println(maxLength);
    }
    
    public static int lis(int[] arr, int idx){
        if(idx==0){
            return 1;
        }
        int ans=1;
        for(int i=idx-1;i>=0;i--){
            if(arr[i]<=arr[idx]){
                ans = Math.max(ans,lis(arr,i)+1);
            }
        }
        return ans;
    }


}