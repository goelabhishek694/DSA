// import java.io.*;
// import java.util.*;

// public class Main {

//    private static class Pair {
//       String psf;
//       int i;
//       int j;

//       public Pair(String psf, int i, int j) {
//          this.psf = psf;
//          this.i = i;
//          this.j = j;
//       }
//    }
//    public static void main(String[] args) throws Exception {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       int n = Integer.parseInt(br.readLine());
//       int m = Integer.parseInt(br.readLine());
//       int[][] arr = new int[n][m];

//       for (int i = 0; i < n; i++) {
//          String str = br.readLine();
//          for (int j = 0; j < m; j++) {
//             arr[i][j] = Integer.parseInt(str.split(" ")[j]);
//          }
//       }

//       //write your code here
//       int gold=Integer.MIN_VALUE;
//       for(int i=0;i<arr.length;i++){
          
//         gold=Math.max(gold,maxGold(arr,i,0));
//         // System.out.println(gold);  
//       }
//       System.out.println(gold);

//    }

//     public static int maxGold(int[][] arr, int i, int j){

//         if(j==arr[0].length-1){
//             return arr[i][j];
//         }
//         int ans=0;
//         if(j+1<arr[0].length){

//             if(i-1>=0){
//                 ans=Math.max(ans,maxGold(arr,i-1,j+1));
//             }
//             if(i+1<arr.length){
//                 ans=Math.max(ans,maxGold(arr,i+1,j+1));
//             }
            
//                 ans=Math.max(ans,maxGold(arr,i,j+1));
            
//         }
//         // System.out.println(ans+arr[i][j]);
//         return ans+arr[i][j];
//     }
// }


import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
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
        int[][]dp=new int[n][m];
        for(int c=arr[0].length-1;c>=0;c--){
            for(int r=0;r<arr.length;r++){
                if(c==arr[0].length-1){
                    dp[r][c]=arr[r][c];
                    continue;
                }
                int maxGold=Integer.MIN_VALUE;
                if(c+1<arr[0].length){
                    if(r+1<arr.length){
                        maxGold=Math.max(maxGold,dp[r+1][c+1]);
                    }
                    if(r-1>=0){
                        maxGold=Math.max(maxGold,dp[r-1][c+1]);
                    }
                    maxGold=Math.max(maxGold,dp[r][c+1]);
                    dp[r][c]=maxGold+arr[r][c];
                }
                
            }
        }
        int res=Integer.MIN_VALUE;
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(dp[i][0]>res){
                res=dp[i][0];
                idx=i;
            }
        }
        
        System.out.println(res);
        System.out.print(idx);
        LinkedList<Pair> queue=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(dp[i][0]==res){
               queue.addLast(new Pair(" ",i,0));
            //   System.out.println("inside while "+i);
                while(queue.size()>0){
                   Pair rp=queue.removeFirst();
                //   System.out.println("rc "+rp.i+" "+rp.j);
                    if(rp.j==arr[0].length-1){
                       System.out.print(rp.psf);
                       continue;
                    }
                    int d1=Integer.MIN_VALUE;
                    int d2=Integer.MIN_VALUE;
                    int d3=Integer.MIN_VALUE;
                    
                    if((rp.j+1)<arr[0].length){
                        if(rp.i+1<arr.length){
                            d3=dp[rp.i+1][rp.j+1];
                            // System.out.println(d3);
                        }
                        if(rp.i-1>=0){
                            d1=dp[rp.i-1][rp.j+1];
                            // System.out.println(d1);
                        }
                        if(rp.i>=0 && rp.i<arr.length){
                            d2=dp[rp.i][rp.j+1];
                            // System.out.println(d2);
                        }
                    }
                    if(d3>d2 && d3>d1){
                        queue.addLast(new Pair(rp.psf+" d3",(rp.i)+1,(rp.j)+1));
                        // System.out.println(d3);
                    }
                    if(d2>d3 && d2>d1){
                        queue.addLast(new Pair(rp.psf+" d2",rp.i,(rp.j)+1));  
                        // System.out.println(d2);
                        
                    }
                    if(d1>d3 && d1>d2){
                        queue.addLast(new Pair(rp.psf+" d1",(rp.i)-1,(rp.j)+1));
                        // System.out.println(d1);
                    }
                }
            }
        }
        //write your code here
    }
}