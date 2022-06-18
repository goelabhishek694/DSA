import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }

        for(int k=0;k<arr.length-1;k++){
            int i=st.pop();
            int j=st.pop();

            if(arr[i][j]==0) st.push(i);
            else st.push(j);
        }

        int idx=st.pop();

        for(int i=0;i<arr.length; i++){
            if(i==idx) continue;
            if(arr[idx][i]!=0){
                System.out.println("none");
                return;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(i==idx) continue;
            if(arr[i][idx]!=1){
                System.out.println("none");
                return;
            }
        }

       System.out.println(idx); 
    }

}