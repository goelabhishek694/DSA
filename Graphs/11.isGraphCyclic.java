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
         // int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
        boolean[] vis=new boolean[vtces];
        for(int i=0;i<vtces;i++){
            if(!vis[i]){
                if(gcc(graph,vis,i)){
                    System.out.println("true");
                    return;
                }
            }
        }
        System.out.println("false");
      // write your code here
   }

   public static boolean gcc(ArrayList<Edge>[] graph,boolean[] vis, int src){
       LinkedList<Integer> que=new LinkedList();
       que.addLast(src);

       while(que.size()>0){
           int rs=que.removeFirst();

           if(vis[rs]){
               return true;
           }
           vis[rs]=true;

           for(Edge e:graph[src]){
               if(!vis[e.nbr]){
                   que.add(e.nbr);
               }
           }
       }

       return false;
   }
}