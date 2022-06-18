import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int ans=tilingDominoes(n);
        System.out.println(ans);
    }

    public static int tilingDominoes(int n){
        if(n<=2) return n;
        int a=1;
        int b=2;
        for(int i=3;i<=n;i++){
            int c=a+b;

            a=b;
            b=c;
        }

        return b;
    }
}

