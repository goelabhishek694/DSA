import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] chess=new int[n][n];
        printNQueens(chess,"",0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }

        for(int i=0;i<chess.length;i++){
            if(canPlace(chess,row,j)){
                chess[row][j]=1;
                printNQueens(chess,qsf+row+"-"+j+", ",row+1);
                chess[row][j]=0;
            }
        }
    }
    static int[][] dirA={{-1,-1},{-1,0},{-1,1}};
    public static boolean canPlace(int[][] chess, int row, int col){

        for(int d=0;d<3;d++){
            for(int jumps=1;jumps<chess.length;jumps++){
                int x=row+jumps*dirA[d][0];
                int y=col+jumps*dirA[d][1];

                if(x>=0 && y>=0 && x<chess.length && y<chess.length){
                    if(chess[x][y]==1) return false;
                }
                else break;
            }
        }
        return true;
    }
}