import java.io.*;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int lidx;
        int didx;
        int data;

        Pair(int lidx, int didx, int data){
            this.lidx=lidx;
            this.didx=didx;
            this.data=data;
        }

        public int compareTo(Pair other){
            return this.data-other.data;
        }
    }

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq=new PriorityQueue<>();
      int lsize=lists.size();
      while(lsize>0){
          lsize=lsize-1;
          pq.add(new Pair(lsize,0,lists.get(lsize).get(0)));
      }
      while(pq.size()>0){
          Pair rp=pq.remove();
          rv.add(rp.data);

          if(lists.get(rp.lidx).size()>rp.didx+1){
            //   rp.didx++;
              pq.add(new Pair(rp.lidx,rp.didx+1,lists.get(rp.lidx).get(rp.didx+1)));
          }

      }
      // System.out.println(rv.size());
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}