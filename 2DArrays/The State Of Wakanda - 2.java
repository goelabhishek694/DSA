import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        // int m=scn.nextInt();

        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        sow2(arr);
    }

    public static void sow2(int[][] arr){

        for(int k=0;k<arr.length;k++){
            for(int i=0,j=k;i<arr.length && j<arr.length;i++,j++){
                System.out.println(arr[i][j]);
            }
            // System.out.println();
        }
    }

}

// 1 2 3 4 5
// 1 2 3 4 5
// 1 2 3 4 5
// 1 2 3 4 5
// 1 2 3 4 5