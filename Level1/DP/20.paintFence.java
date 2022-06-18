import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();

        int ans=paintFences(n,k);
        System.out.println(ans);
    }

    public static int paintFences(int n, int k){
        // int[] dp=new int[n];
        int repeat=0;
        int nonRepeat=k;
        for(int i=2;i<=n;i++){
            int newRepeat=nonRepeat;
            int newNonRepeat=repeat*(k-1)+nonRepeat*(k-1);

            repeat=newRepeat;
            nonRepeat=newNonRepeat;
        }

        return repeat+nonRepeat;
    }
}