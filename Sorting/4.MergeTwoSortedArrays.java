import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int al=a.length;
    int bl=b.length;
    int[] arr=new int[al+bl];

    int i=0; int j=0; int k=0;
    while(i<al && j<bl){
        if(a[i]>b[j]){
            arr[k]=b[j];
            j++;
        }
        else{
            arr[k]=a[i];
            i++;
        }
        k++; 
    }

    if(i==al){
        while(j<bl){
            arr[k]=b[j];
            j++;
            k++;
        }
    }
    else if(j==bl){
        while(i<al){
            arr[k]=a[i];
            i++;
            k++;
        }
    }
    
    return arr;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}