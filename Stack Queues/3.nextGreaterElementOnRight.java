import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   Stack<Integer> st=new Stack<>();
   int[] ans=new int[arr.length];
   Arrays.fill(ans,-1);
   for(int i=0;i<arr.length;i++){
       while(!st.empty() && arr[i]>arr[st.peek()]){
           int idx=st.peek();
           st.pop();
           ans[idx]=arr[i];
       }
       st.push(i);
   }
   return ans;
 }

}