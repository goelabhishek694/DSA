import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] chess=new int[n][n];
        int row=scn.nextInt();
        int col=scn.nextInt();
        chess[row][col]=1;
        printKnightsTour(chess,row,col,1);
        // displayBoard(chess);
    }
    static int[][] dirA={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(upcomingMove==chess.length*chess.length){
            displayBoard(chess);
            return;
        }
        for(int d=0;d<8;d++){
            int x=r+dirA[d][0];
            int y=c+dirA[d][1];

            if(x>=0 && y>=0 && x<chess.length && y<chess[0].length && chess[x][y]==0){
                chess[x][y]=upcomingMove+1;
                printKnightsTour(chess,x,y,upcomingMove+1);
                chess[x][y]=0;
            }
        }
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}