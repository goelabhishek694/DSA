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

        printSpiralDisplay(arr);
    }

    public static void printSpiralDisplay(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;

        int minRow=0;
        int minCol=0;
        int maxRow=row-1;
        int maxCol=col-1;
        int count=0;
        while(count<row*col){
            //top to bottom row
            for(int i=minRow;i<maxRow;i++){
                System.out.println(arr[i][minCol]);
                count++;
            }
            minCol++;

            // left to right col 
            for(int i=minCol;i<maxCol;i++){
                System.out.println(arr[maxRow][i]);
                count++;
            }
            maxRow--;

            // bottom to top row
            for(int i=maxRow;i>=minRow;i--){
                System.out.println(arr[i][maxCol]);
                count++;
            }
            maxCol--;
            // right to left col
            for(int i=maxCol;i>minCol;i--){
                System.out.println(arr[minRow][i]);
                count++;
            }
            minRow++;
        }
    }

}

//leetcode 54

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=arr.length;
        int col=arr[0].length;

        int minRow=0;
        int minCol=0;
        int maxRow=row-1;
        int maxCol=col-1;
        int count=0;
        List<Integer> list=new ArrayList<>();
        while(count<row*col){

            // left to right col 
            for(int i=minCol;i<=maxCol && count<row*col ;i++){
                list.add(arr[minRow][i]);
                count++;
            }
            minRow++;

            //top to bottom row
            for(int i=minRow;i<=maxRow && count<row*col;i++){
                list.add(arr[i][maxCol]);
                count++;
            }
            maxCol--;

            // right to left col
            for(int i=maxCol;i>=minCol && count<row*col;i--){
                list.add(arr[maxRow][i]);
                count++;
            }
            maxRow--;

            // bottom to top row
            for(int i=maxRow;i>=minRow && count<row*col;i--){
                list.add(arr[i][minCol]);
                count++;
            }
            minCol++;       
        }
        return list;
    }
}