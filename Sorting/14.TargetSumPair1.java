import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    //write your code here
    int lo=0; int hi=arr.length-1;
    int[] ar=mergeSort(arr,lo,hi);
    // sortedArray(arr);
    int i=0; int j=ar.length-1;
    // for(int ele:ar) System.out.println(ele);
    while(i<j){
      // System.out.println("inside");
        if(ar[i]+ar[j]<target){
            i++;
        }
        else if(ar[i]+ar[j]>target){
            j--;
        }
       else{
           System.out.println(ar[i]+", "+ar[j]);
           i++;
           j--;
       }
    }

  }

  public static int[] mergeSort(int[] arr,int lo, int hi){
      if(lo==hi){
          int[] bres=new int[1];
          bres[0]=arr[lo];
          return bres;
      }

      int mid=(lo+hi)/2;
      int[] a=mergeSort(arr,lo,mid);
      int[] b=mergeSort(arr,mid+1,hi);
      int[] res=mergeTwoSortedArrays(a,b);

      return res;
  }

  public static int[] mergeTwoSortedArrays(int[] a, int [] b){
      int al=0;
      int bl=0;
      int k=0;
      int[] res=new int[a.length+b.length];
      while(al<a.length && bl<b.length){
          if(a[al]<=b[bl]){
              res[k]=a[al];
              al++;
          }
          else if(a[al]>b[bl]){
              res[k]=b[bl];
              bl++;
          }
          k++;
      }
      while(al<a.length){
        res[k]=a[al];
        al++; k++;
      }
      while(bl<b.length){
        res[k]=b[bl];
        bl++; k++;
      }
      return res;
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}