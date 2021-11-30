import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void Solution(int arr[],int idx){
        // write your code here
        if(idx>=arr.length-1){
            return 0;
        }
        if(arr[idx]==0) return Integer.MAX_VALUE;
        int minJump=Integer.MAX_VALUE;

        for(int j=1;j<=arr[i];j++){
            int ans=Solution(arr,idx+j)
            int jump=(ans==Integer.MAX_VALUE)?ans:ans+1
            minJump=Math.min(minJump,jump);
        }
        return minJump;
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr,0);
        scn.close();
    }
}
