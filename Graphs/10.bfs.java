import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class Pair{
       int src;
       String psf;

       Pair(int src, String psf){
           this.src=src;
           this.psf=psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here
      bfs(graph, vtces,src);
   }

   public static void bfs(ArrayList<Edge> graph[], int n, int src){
       boolean[] vis=new boolean[n];
       LinkedList<Pair> que=new LinkedList<>();
       que.addLast(new Pair(src,""+src));

       while(que.size()>0){
           Pair rp=que.removeFirst();
           if(vis[rp.src]){
               continue;
           }
           System.out.println(rp.src+"@"+rp.psf);
           vis[rp.src]=true;
           for(Edge e:graph[rp.src]){
               if(!vis[e.nbr]){
                   que.addLast(new Pair(e.nbr,rp.psf+e.nbr));
               }
           }
       }
   }
}