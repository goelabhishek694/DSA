import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        exitPoint(arr);
    }

    public static void exitPoint(int[][] arr){
        int[][] dirA={{1,0},{0,-1},{-1,0},{0,1}};
        int count=-1;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                
            }
        }
    }

}