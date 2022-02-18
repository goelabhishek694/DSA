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

        int s=scn.nextInt();
        int r=scn.nextInt();

        ringRotate(arr,s,r);
    }

    public static void ringRotate(int[][] arr, int s , int r){

        int startRow=s-1;
        int startCol=s-1;
        int endRow=arr.length-s;
        int endCol=arr[0].length-s;
        int size=2*((endRow-startRow+1)+(endCol-startCol+1))-4;
        int[] rotate=new int[size];
        int idx=0;

        while(idx<size){
            for(int i=startRow,j=startCol;j<=endCol;j++){
                rotate[idx]=arr[i][j];
                idx++;
            }
            startRow++;

            for(int i=startRow,j=endCol;i<=endRow;i++){
                rotate[idx]=arr[i][j];
                idx++;
            }
            endCol--;

            for(int i=endRow,j=endCol;j>=startCol;j--){
                rotate[idx]=arr[i][j];
                idx++;
            }
            endRow--;

            for(int i=endRow,j=startCol;i>=startRow;i--){
                rotate[idx]=arr[i][j];
                idx++;
            }
            startCol++;
        }

        for(int i=0;i<r;i++){
            int temp=rotate[0];
            for(int j=1;j<size;j++){
                rotate[j-1]=rotate[j];
            }
            rotate[size-1]=temp;
        }
        //for printing rotated 1d array 
        // for(int i=0;i<size;i++){
        //     System.out.println(rotate[i]);
        // }
        idx=0;
        // System.out.println(startRow);
        // System.out.println(startCol);
        // System.out.println(endRow);
        // System.out.println(endCol);
        startRow=s-1;
         startCol=s-1;
         endRow=arr.length-s;
         endCol=arr[0].length-s;
        while(idx<size){
            for(int i=startRow,j=startCol;j<=endCol && idx<size;j++){
                arr[i][j]=rotate[idx];
                idx++;
            }
            startRow++;

            for(int i=startRow,j=endCol;i<=endRow && idx<size;i++){
                arr[i][j]=rotate[idx];
                idx++;
            }
            endCol--;

            for(int i=endRow,j=endCol;j>=startCol && idx<size;j--){
                arr[i][j]=rotate[idx];
                idx++;
            }
            endRow--;

            for(int i=endRow,j=startCol;i>=startRow && idx<size;i--){
                arr[i][j]=rotate[idx];
                idx++;
            }
            startCol++;
        }

        display(arr);

    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}