import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }
      int count=0;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(arr[i][j]==0){
                  arr[i][j]=1;
                  gcc(arr,i,j);
                  count++;
              }
          }
      }
      System.out.println(count);

      // write your code here
   }
   static int[][] dirA={{-1,0},{0,1},{1,0},{0,-1}};
   public static void gcc(int[][] arr, int row, int col){
       for(int i=0;i<4;i++){
           int x=row+dirA[i][0];
           int y=col+dirA[i][1];

           if(x>=0 && y>=0 && x<arr.length && y<arr[0].length && arr[x][y]==0){
               arr[x][y]=1;
               gcc(arr,x,y);
           }
       }
   }

}

//leetcode 547

class Solution {
    class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    graph[i].add(new Edge(i,j));
                }
            }
        }
        return numProvincesHelper(graph,vis,n);
    }

    
    
    public int numProvincesHelper(ArrayList<Edge>[] graph, boolean[] vis, int n){
        int count=0;
        for(int i=0;i<n;i++){
          if(!vis[i]){
              vis[i]=true;
              getConnectedComponents(graph,vis,i);
              count++;
          }
        }
        return count;
    }
    
    public void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] vis,int src){
        
        for(Edge e:graph[src]){
            if(!vis[e.nbr]){
                vis[e.nbr]=true;
                getConnectedComponents(graph,vis,e.nbr);
            }
        }
    }
}