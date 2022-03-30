import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for(int i = 0; i < edges; i++){
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write your code here
      boolean[]vis=new boolean[vtces];
      boolean res=dfs(graph,src,dest,vis);
      System.out.println(res);
    }

    public static boolean dfs(ArrayList<Edge>[] graph,int src,int dest, boolean[] vis){
        if(src==dest) return true;

        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.nbr]){
                if(dfs(graph,e.nbr,dest,vis)){
                    return true;
                }
            }
        }
        vis[src]=false;

        return false;
    }

}
//leetcode 
// class Solution {
//     class Edge{
//         int src;
//         int nbr;
        
//         Edge(int src, int nbr){
//             this.src=src;
//             this.nbr=nbr;
//         }
//     }
    
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         ArrayList<Edge> [] graph=new ArrayList[n];
//         for(int i=0;i<n;i++){
//             graph[i]=new ArrayList<>();
//         }
//         for(int i=0;i<edges.length;i++){
//             int v1=edges[i][0];
//             int v2=edges[i][1];

//             graph[v1].add(new Edge(v1,v2));
//             graph[v2].add(new Edge(v2,v1));
//         }
//         boolean[] visited=new boolean[n];
//         return validPathHelper(graph,source,destination,visited);
//         // System.out.pritnln(res);
//     }

//     public boolean validPathHelper(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
//         if(src==dest){
//             return true;
//         }
//         vis[src]=true;
//         for(Edge edge:graph[src]){
//             if(!vis[edge.nbr]){
//                 if(validPathHelper(graph,edge.nbr,dest,vis)) return true;
//             }
//         }
//         vis[src]=false;

//         return false;
//     }
// }