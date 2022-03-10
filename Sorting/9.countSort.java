import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
    int range=max-min+1;
    int[] farr=new int[range];
    
    //creating freq map
    for(int i=0;i<arr.length;i++){
        farr[arr[i]-min]++;
    }

    //creating prefix arr 
    for(int i=1;i<farr.length;i++){
        farr[i]=farr[i-1]+farr[i];
    }

    //decreasing each farr by 1 to get idx
    for(int i=0;i<farr.length;i++){
        farr[i]--;
    }
    // creating ans array and fill ans backwards to get stable sort 
    int[] ans=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        int ele=arr[i];
        int idx=farr[ele-min];
        ans[idx]=ele;
        farr[ele-min]--;
    }

    //place elements of "ans" array to "arr" array
    for(int i=0;i<ans.length;i++){
        arr[i]=ans[i];
    }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}