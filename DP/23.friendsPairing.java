import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n =scn.nextInt();

        int ans=friendsPairing(n);
        System.out.println(ans);
    }

    public static int friendsPairing(int n){
        // int[] dp=new int[n];
        int slast=1;
        int last=2;

        for(int i=2;i<n;i++){
            int curr=last+i*slast;

            slast=last;
            last=curr;
            
        }

        return n==1?1:last;
    }

}