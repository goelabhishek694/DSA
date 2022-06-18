import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr,(int[] a, int[] b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int cst=arr[i][0];
            int cet=arr[i][1];
            if(st.size()>0 && cst<=st.peek()){
                int pet=st.pop();
                // int pst=st.pop();

                // st.push(pst); 
                st.push(Math.max(pet,cet));
            }
            else{
                st.push(cst);
                st.push(cet);
            }
            
        }
        Stack<Integer> nst=new Stack<>();
        while(st.size()>1){
            nst.push(st.pop());
            nst.push(st.pop());
        }

        while(nst.size()>1){
            System.out.println(nst.pop()+" "+nst.pop());
        }

    }

}