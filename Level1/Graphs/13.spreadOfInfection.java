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
       int level;

       Pair(int src,int level){
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
      
      // write your code here
        boolean[] vis=new boolean[vtces];
      
        System.out.println(bfs(graph,vis,src,t));
   }

   public static int bfs(ArrayList<Edge>[] graph, boolean[] vis, int src, int t){
        LinkedList<Pair> que=new LinkedList<>();
        int count=0;
        que.add(new Pair(src,1));

        while(que.size()>0){
            Pair rp=que.removeFirst();
            if(rp.level==t+1) return count;
            if(vis[rp.src]){
                continue;
            }
            count++;
            vis[rp.src]=true;
            for(Edge e:graph[rp.src]){
                if(!vis[e.nbr]){
                    que.add(new Pair(e.nbr,rp.level+1));
                }
            }  
        }
        return 0;

   }

}