import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      int i;
      int j;
      String psf;
      public Pair(int i, int j,String psf) {
         this.i = i;
         this.j = j;
         this.psf = psf;
      }
   }
   
   public static void minCostPath(int[][] arr, int x, int y){
    int[][] dp=new int[x+1][y+1];   
    
    for(int i=x;i>=0;i--){
        for(int j=y;j>=0;j--){
            if(i==arr.length-1 && j==arr[0].length-1){
                dp[i][j]=arr[i][j];
                continue;
            }
            int minCost=Integer.MAX_VALUE;
            if(i+1<arr.length){
                minCost=Math.min(minCost,dp[i+1][j]);
            }
            if(j+1<arr[0].length){
                minCost=Math.min(minCost,dp[i][j+1]);
            }
            dp[i][j]=arr[i][j]+minCost;
        }   
    }
     System.out.println(dp[0][0]);
    LinkedList<Pair> queue=new LinkedList<>();
    queue.addLast(new Pair(0,0,""));

    while(queue.size()>0){
        Pair rp=queue.removeFirst();
        
        int X=rp.i;
        int Y=rp.j;
        if(X==dp.length-1 && Y==dp[0].length-1) {
            System.out.println(rp.psf);
            continue;
        }
        int hCost=Integer.MAX_VALUE;
        int vCost=Integer.MAX_VALUE;
        if(X+1<arr.length) vCost=dp[X+1][Y];
        if(Y+1<arr[0].length) hCost=dp[X][Y+1];
        if (vCost<=hCost) queue.addLast(new Pair(X+1,Y,rp.psf+"V"));
        if (hCost<=vCost) queue.addLast(new Pair(X,Y+1,rp.psf+"H"));
        
        
    }
    
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      minCostPath(arr,n-1,m-1);
    //   System.out.println(ans);
   }

}





