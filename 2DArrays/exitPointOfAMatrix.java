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
        int curDir=3;
        int i=0; int j=0;

        while(i<arr.length && j<arr[0].length  && i>=0 && j>=0){
            int val=arr[i][j];
            if(val==0){
                i=i+dirA[curDir%4][0];
                j=j+dirA[curDir%4][1];
            }
            else if(val==1){
                curDir++;
                arr[i][j]=0;
                i=i+dirA[curDir%4][0];
                j=j+dirA[curDir%4][1];
            }
        }
        i=i-dirA[curDir%4][0];
        j=j-dirA[curDir%4][1];
        System.out.println(i);
        System.out.println(j);
    }

}