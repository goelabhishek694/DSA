import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        
        int oldRed=0;
        int oldBlue=0;
        int oldGreen=0;

        for(int house=0;house<arr.length;house++){

            int newRed=Math.min(oldBlue,oldGreen)+arr[house][0];
            int newBlue=Math.min(oldRed,oldGreen)+arr[house][1];
            int newGreen=Math.min(oldBlue,oldRed)+arr[house][2];

            oldRed=newRed;
            oldBlue=newBlue;
            oldGreen=newGreen;
        }
        int minCost=Math.min(oldRed,Math.min(oldBlue,oldGreen));
        System.out.println(minCost);
    }
}