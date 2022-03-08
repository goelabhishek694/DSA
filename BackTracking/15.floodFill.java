import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "");
    }
    
    // // asf -> answer so far
    // public static void floodfill(int[][] maze, int sr, int sc, String asf) {
    //     if(sr==maze.length-1 && sc==maze[0].length-1){
    //         System.out.println(asf);
    //         return;
    //     }
    //     maze[sr][sc]=1;
    //     if(sr-1>=0 && maze[sr-1][sc]!=1){
    //         maze[sr-1][sc]=1;
    //         floodfill(maze,sr-1,sc,asf+"t");
    //         maze[sr-1][sc]=0;
    //     }
    //     if(sc-1>=0 && maze[sr][sc-1]!=1){
    //         maze[sr][sc-1]=1;
    //         floodfill(maze,sr,sc-1,asf+"l");
    //         maze[sr][sc-1]=0;
    //     }
    //     if(sr+1<maze.length && maze[sr+1][sc]!=1){
    //         maze[sr+1][sc]=1;
    //         floodfill(maze,sr+1,sc,asf+"d");
    //         maze[sr+1][sc]=0;
    //     }
    //     if(sc+1<maze[0].length && maze[sr][sc+1]!=1){
    //         maze[sr][sc+1]=1;
    //         floodfill(maze,sr,sc+1,asf+"r");
    //         maze[sr][sc+1]=0;
    //     }
    //     maze[sr][sc]=0;        
    // }
    static int[][] dirA={{-1,0},{0,-1},{1,0},{0,1}};
    static String[] codes={"t","l","d","r"};
    public static void floodfill(int[][] maze, int sr, int sc, String asf) {

        for(int i=0;i<4;i++){
            int x=sr+dirA[i][0];
            int y=sc+dirA[i][1];

            if(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]!=1){
                maze[x][y]=1;
                floodfill(maze,x,y,asf+codes[i]);
                maze[x][y]=0;
            }
        }         
    }
}