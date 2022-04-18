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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine()); 

        //write your code here
        tarSum(arr,0,tar);
        // System.out.println(ans);
    }

    // public static boolean tarSum(int[] arr, int idx, int tar){
    //     if(idx==arr.length){
    //         if(tar==0){
    //             return true;
    //         }
    //         return false;
    //     }
    //     boolean res=false;
    //     if(tar-arr[idx]>=0){
    //         res=res||tarSum(arr,idx+1, tar-arr[idx]);
    //     }
    //     res=res||tarSum(arr,idx+1,tar);

    //     return res;
    // }
    
    public static void tarSum(int[] arr, int idx, int tar){
        boolean[][] dp=new boolean[arr.length+1][tar+1];
        // boolean Res=false;
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=tar;j++){
                boolean res=false;
                if(i==0){
                    if(j==0) dp[i][j]=true;
                    else dp[i][j]=false;
                    continue;
                }
                
                if(j-arr[i-1]>=0){
                    res=dp[i-1][j-arr[i-1]];
                }
                res=res||dp[i-1][j];
                dp[i][j]=res;
                // res=Res;
            }
        }
        boolean Res=dp[arr.length][tar];
        System.out.println(Res);
        // for(boolean[] a:dp){
        //     for(boolean ele:a){
        //         System.out.print(ele+" ");
        //     }
        //     System.out.println();
        // }
        if(Res){
            LinkedList<Pair> queue=new LinkedList<>();
            queue.addLast(new Pair(arr.length,tar,""));

            while(queue.size()>0){
                Pair rp=queue.removeFirst();

                if(rp.j==0 || rp.i==0){
                    System.out.println(rp.psf);
                    continue;
                }
                boolean flag=false;
                if(rp.j-arr[rp.i-1]>=0 && dp[rp.i-1][rp.j-arr[rp.i-1]]){
                    queue.addLast(new Pair(rp.i-1,rp.j-arr[rp.i-1],rp.i-1+" "+rp.psf));
                }
                if(dp[rp.i-1][rp.j]){
                    queue.addLast(new Pair(rp.i-1,rp.j,rp.psf));    
                }
                
            }
        }
    }  
}               