import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      boolean[] vis=new boolean[vtces];
      // write your code here
      for(int i=0;i<vtces;i++){
          if(!vis[i]){
              vis[i]=true;
              ArrayList<Integer> res=new ArrayList<>();
              res.add(i);
              getConnectedComponents(graph,vis,res,i);
              comps.add(res);
            //   count++;
          }
      }

      System.out.println(comps);
   }

   public static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] vis, ArrayList<Integer> res, int src){

       for(Edge e:graph[src]){
           if(!vis[e.nbr]){
               vis[e.nbr]=true;
               res.add(e.nbr);
               getConnectedComponents(graph,vis,res,e.nbr);
           }
       }
   }
}