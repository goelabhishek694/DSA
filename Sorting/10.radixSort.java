import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here    
    int max=Integer.MIN_VALUE;
    for(int ele:arr){
        max=Math.max(max,ele);
    }
    int exp=1;
    while(exp<=max){
        countSort(arr,exp);
        exp=exp*10;
    }
  }

  public static void countSort(int[] arr, int exp) {
      int[] farr=new int[10];
      //creating farr
      for(int i=0;i<arr.length;i++){
          farr[arr[i]/exp%10]++;
      }
      //creatin prefix sum
      for(int i=1;i<farr.length;i++){
          farr[i]=farr[i]+farr[i-1];
      }
      //prefix sum to idx 
      for(int i=0;i<farr.length;i++){
          farr[i]--;
      }

      int[] ans=new int[arr.length];
      for(int i=arr.length-1;i>=0;i--){
          int ele=arr[i]/exp%10;
          int idx=farr[ele];
          ans[idx]=arr[i];
          farr[ele]--;
      }

      for(int i=0;i<arr.length;i++){
          arr[i]=ans[i];
      }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}