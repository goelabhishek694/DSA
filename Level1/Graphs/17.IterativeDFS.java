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
        boolean[] vis=new boolean[vtces];
        iterativeDFS(graph,vis,src);
   }

   public static void iterativeDFS(ArrayList<Edge>[] graph, boolean[] vis, int src){
        Stack<Pair> st=new Stack<>();
         st.push(new Pair(src,""+src));
        while(st.size()>0){
            Pair rp=st.pop();

            if(vis[rp.src]){
                continue;
            }
            vis[rp.src]=true;
            System.out.println(rp.src+" @ "+rp.psf);
        
            for(Edge e:graph[rp.src]){
                if(!vis[e.nbr]){
                    st.push(new Pair(e.nbr,rp.psf+e.nbr));
                }
            }
        }
   }
}