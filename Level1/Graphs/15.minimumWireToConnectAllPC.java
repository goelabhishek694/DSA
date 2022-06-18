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

   static class Pair implements Comparable<Pair>{
       int src;
       int parent;
       int cost;

       Pair(int src, int parent, int cost){
           this.src=src;
           this.parent=parent;
           this.cost=cost;
       }

       public int compareTo(Pair other){
           return this.cost-other.cost;
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

      // write your code here
      boolean[] vis=new boolean[vtces];
      minimumWireToConnectAllPC(graph,vis,0);
   }

   public static void minimumWireToConnectAllPC(ArrayList<Edge>graph [], boolean[] vis, int src){
       PriorityQueue<Pair> pq=new PriorityQueue<>();
       pq.add(new Pair(src,-1,0));
        // System.out.println("hello");
       while(pq.size()>0){
            Pair rp=pq.remove();
            if(vis[rp.src]){
                continue;
            }
            vis[rp.src]=true;
            if(rp.parent!=-1){
                System.out.println("["+rp.src+"-"+rp.parent+"@"+rp.cost+"]");
            }
            for(Edge e:graph[rp.src]){
                if(!vis[e.nbr]){
                    pq.add(new Pair(e.nbr,rp.src,e.wt));
                }
            }
       }
   }

}