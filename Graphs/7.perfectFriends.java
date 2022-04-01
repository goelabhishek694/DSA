import java.io.*;
import java.util.*;

public class Main {
   static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr){
            this.src=src;
            this.nbr=nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<k;i++){
            String parts=br.readLine();
            int v1=Integer.parseInt(parts.split(" ")[0]);
            int v2=Integer.parseInt(parts.split(" ")[1]);

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
      
      // write your code here
        boolean[]vis=new boolean[n];
        // int count=0;
        ArrayList<Integer> sizeOfGroups=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                int noe=gcc(graph,vis,i);
               //  System.out.println(noe);
                sizeOfGroups.add(noe+1);
            }
        }
        int count=0;
        for(int i=0;i<sizeOfGroups.size();i++){
            for(int j=i+1;j<sizeOfGroups.size();j++){
                count+=sizeOfGroups.get(i)*sizeOfGroups.get(j);
            }
        }


        System.out.println(count); 
    }

    public static int gcc(ArrayList<Edge>graph[], boolean[]vis, int src){
        int count=0;
        for(Edge e:graph[src]){
            if(!vis[e.nbr]){
                vis[e.nbr]=true;
                count+=gcc(graph,vis,e.nbr)+1;
            }
        }
        return count;
    }

} 


// journey to moon - hackerrank

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    class Edge{
        int src;
        int nbr;

        Edge(int src, int nbr){
            this.src=src;
            thi.nbr=nbr;
        }
    }
    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
    boolean[] vis=new boolean[n];
    ArrayList<Edge>graph[]=new ArrayList[n];
    for(int i=0;i<n;i++){
        graph[i]=new ArrayList<>();
    }

    for(int i=0;i<astronaut.size();i++){
        int v1=astronaut.get(i).get(0);
        int v2=astronaut.get(i).get(1);

        graph[v1].add(new Edge(v1,v2));
        graph[v2].add(new Edge(v2,v1));
    }
    ArrayList<Integer> res=new ArrayList<>();
    for(int i=0;i<n;i++){
        if(!vis[i]){
            vis[i]=true;
            int noe=journeyToMoonHelper(graph,vis,src);
            res.add(noe+1);
        }
    }
    int[] prefix=new int[res.size()];
    for(int i=res.size()-2;i>=0;i--){
        prefix[i]=
    }

    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
