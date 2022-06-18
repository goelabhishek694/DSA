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

   static class Pair{
       int src;
       int level;

       Pair(int src, int level){
           this.src=src;
           this.level=level;
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
    int[] vis=new int[vtces];
    // not visited = -1
    // visited = 0 or 1
    Arrays.fill(vis,-1);
      for(int i=0;i<vtces;i++){
          if(vis[i]==-1){
              if(!isBipartite(graph,vis,i)){
                  System.out.println("false");
                  return;
              }
          }
      }
      System.out.println("true");
   }

   public static boolean isBipartite(ArrayList<Edge>[] graph, int[] vis, int src){
       LinkedList<Pair> que=new LinkedList<>();
       que.addLast(new Pair(src,0));

       while(que.size()>0){
            Pair rp=que.removeFirst();
            if(vis[rp.src]!=-1){ //if visited
                if(vis[rp.src]!=rp.level%2){ //
                    return false;
                }
            }

            vis[rp.src]=rp.level%2;
            for(Edge e:graph[src]){
                if(vis[e.nbr]==-1){
                    que.addLast(new Pair(e.nbr,rp.level+1));
                }
            }
       }
       return true;
   }
}