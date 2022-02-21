import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] arr=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int target=scn.nextInt();

        searchInSorted2DArray(arr,target);
    }

    public static void searchInSorted2DArray(int[][] arr, int target){
        int row=0;
        int col=arr.length-1;

        while(row>=0 && col>=0 && row<arr.length && col<arr.length){
            if(arr[row][col]>target){
                col--;
            }
            else if(arr[row][col]<target){
                row++;
            }
            else{
                System.out.println(row);
                System.out.println(col);
                return;
            }
        }

        System.out.println("Not Found");
    }

}