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

        findeSaddlePrice(arr);
    }

    public static void findeSaddlePrice(int[][] arr){
        int n=arr.length;
        // int;
        for( int i=0;i<n;i++){
            int minVal=Integer.MAX_VALUE;
            int col=0 ; int j;
            for(j=0;j<n;j++){
                if(arr[i][j]<minVal){
                    col=j;
                    minVal=arr[i][j];
                }
            }
            int maxVal=Integer.MIN_VALUE;
            for(int k=0;k<arr.length;k++){
                if(arr[k][col]>maxVal){
                    maxVal=arr[k][col];
                }
            }
            if(minVal==maxVal) {
                System.out.println(maxVal);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}