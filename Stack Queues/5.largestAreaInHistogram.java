import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int ans = largestAreaInHistogram(a);
    System.out.println(ans);
  }

  public static int largestAreaInHistogram(int[] arr){
      int[] right=nsor(arr);
      int[] left=nsol(arr);
      int area=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
          int breadth=right[i]-left[i]-1;
          int height=arr[i];
          area=Math.max(area,breadth*height);
      }

      return area;
  }

  public static int[] nsor(int[] arr){
      Stack<Integer> st=new Stack<>();
      int[] right=new int[arr.length];
      Arrays.fill(right,arr.length);
      for(int i=0;i<arr.length;i++){
          while(st.size()>0 && arr[i]<arr[st.peek()]){
              int idx=st.peek();
              st.pop();
              right[idx]=i;
          }
          st.push(i);
      }
      return right;
  }

  public static int[] nsol(int[] arr){
      Stack<Integer> st=new Stack<>();
      int[] left=new int[arr.length];
      Arrays.fill(left,-1);
      for(int i=arr.length-1;i>=0;i--){
          while(st.size()>0 && arr[i]<arr[st.peek()]){
              int idx=st.peek();
              st.pop();
              left[idx]=i;
          }
          st.push(i);
      }
      return left;
  }
}
