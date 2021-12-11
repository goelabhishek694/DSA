import java.io.*;
import java.util.*;

public class Main {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());
        knapsack(values,wts,cap,0);
        //write your code here
        
    }

    // public static int knapsack(int[] values,int[] wts,int cap, int idx){
    //     if(cap==0){
    //         return 0;
    //     }
    //     int res=0;
    //     for(int i=idx;i<values.length;i++){
    //         if(cap-wts[i]>=0){
    //             res=Math.max(res,knapsack(values,wts,cap-wts[i],i+1)+values[i]);
    //         }
    //     }
    //     return res;
    // }
    public static void knapsack(int[] values,int[] wts,int cap, int idx){
        int[][]dp=new int[values.length+1][cap+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0){
                    dp[i][j]=0;
                    continue;
                }
                int exc=dp[i-1][j];
                int inc=0;
                if(j-wts[i-1]>=0){
                    inc=dp[i-1][j-wts[i-1]]+values[i-1];
                }
                dp[i][j]=Math.max(exc,inc);
            }
        }
        System.out.println(dp[wts.length][cap]);

        LinkedList<Pair> queue=new LinkedList<>();
        queue.addLast(new Pair(values.length,cap,""));
        while(queue.size()>0){
            Pair rp=queue.removeFirst();
            int capacityOfBag=rp.j;
            int weightIdx=rp.i;
            if(capacityOfBag==0 || weightIdx==0){
                System.out.println(rp.psf);
                continue;
            }

            int exc=dp[weightIdx-1][capacityOfBag];
            if(exc==dp[weightIdx][capacityOfBag]){
                queue.addLast(new Pair(weightIdx-1,capacityOfBag,rp.psf));
            }
            if(capacityOfBag-wts[weightIdx-1]>=0 && dp[weightIdx-1][capacityOfBag-wts[weightIdx-1]]+values[weightIdx-1]==dp[weightIdx][capacityOfBag]){
                queue.addLast(new Pair(weightIdx-1,capacityOfBag-wts[weightIdx-1],weightIdx-1+" "+rp.psf));
            }
        }
        
    }
}


                        


                        


                                                                          