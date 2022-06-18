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
      
      boolean[] vis=new boolean[vtces];
      // write your code here
      int count=0;
      for(int i=0;i<vtces;i++){
          if(!vis[i]){
              vis[i]=true;
            //   ArrayList<Integer> res=new ArrayList<>();
            //   res.add(i);
              getConnectedComponents(graph,vis,i);
            //   comps.add(res);
              count++;
          }
      }
      if(count>1){
         System.out.println(false);
      }
      else System.out.println(true);

      
   }

   public static void getConnectedComponents(ArrayList<Edge>[] graph, boolean[] vis, int src){

       for(Edge e:graph[src]){
           if(!vis[e.nbr]){
               vis[e.nbr]=true;
               getConnectedComponents(graph,vis,e.nbr);
           }
       }
   }
}