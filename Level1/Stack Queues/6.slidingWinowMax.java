import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());
    int[] res=slidingWindowMaximum(a,k);
    for(int ele:res) System.out.println(ele);
    // code
 }

 public static int[] slidingWindowMaximum(int[] arr, int k){
     int[] right=ngor(arr);
     int[] max=new int[arr.length-k+1];
     int j=0;
     for(int i=0;i<=arr.length-k;i++){
         if(j<i) j=i;
         while(right[j]<i+k){
             j=right[j];
         }
         max[i]=arr[j];
     }
     return max;
 }

 public static int[] ngor(int[] arr){
     int[] res=new int[arr.length];
     Arrays.fill(res,arr.length);
     Stack<Integer> st=new Stack<>();
     for(int i=0;i<arr.length;i++){
         while(st.size()>0 && arr[i]>arr[st.peek()]){
             int idx=st.peek();
             st.pop();
             res[idx]=i;
         }
         st.push(i);
     }

     return res;
 }
}