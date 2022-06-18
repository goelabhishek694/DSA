import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int r=scn.nextInt();
        int c=scn.nextInt();

        int[][] chess=new int[n][n];
        chess[r][c]=1;
        printKnightsTour(chess,r,c,2);
    }

    static int[][]dirA={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(upcomingMove==(chess.length*chess.length)+1){
            // System.out.println("hello");
            displayBoard(chess);
            return;
        }

        for(int i=0;i<dirA.length;i++){
            int x=r+dirA[i][0];
            int y=c+dirA[i][1];

            if(x>=0 && y>=0 && x<chess.length && y<chess.length && chess[x][y]==0){
                chess[x][y]=upcomingMove;
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