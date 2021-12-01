import java.util.*;

public class Main{
    public static class Pair{
        int i;
        int s;
        int j;
        String psf;

        Pair(int i,int s,int j,String psf){
            this.i=i;
            this.j=j;
            this.s=s;
            this.psf=psf;
        }
    }

    public static void Solution(int arr[]){
        // write your code here
        int n=arr.length-1;
        int[] dp=new int[n+1];
        for(int i=n;i>=0;i--){
            if(i>=arr.length-1){
            dp[i]=0;
            continue;
            }
            if(arr[i]==0) {
                dp[i]=Integer.MAX_VALUE;
                continue;
            }
                
            int minJump=Integer.MAX_VALUE;
    
            for(int j=1;j<=arr[i];j++){
                if(i+j<=n){
                int ans=dp[i+j];
                int jump=(ans==Integer.MAX_VALUE)?ans:ans+1;
                minJump=Math.min(minJump,jump);
                }
            }
            dp[i]=minJump;
        }
         System.out.println(dp[0]);
         LinkedList<Pair> queue=new LinkedList<>();
         queue.addLast(new Pair(0,arr[0],dp[0],"0"));
         while(queue.size()>0){
              Pair rp=queue.removeFirst();

              if(rp.i==arr.length-1){
                  System.out.println(rp.psf+" .");
              }


             for(int j=1;j<=rp.s;j++){
                if(rp.i+j<arr.length && dp[rp.i+j]!=Integer.MAX_VALUE && dp[rp.i+j]==rp.j-1){
                    queue.addLast(new Pair(rp.i+j,arr[rp.i+j],dp[rp.i+j],rp.psf+" -> "+(rp.i+j)));
                }
             }
         }

    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        // System.out.println(a);
        scn.close();
    }
}



















