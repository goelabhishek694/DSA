import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();

        ArrayList<String> res=getMazePaths(0,0,n-1,m-1);
        System.out.println(res);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> bres=new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mres=new ArrayList<>();
        if(sc+1<=dc){
            ArrayList<Integer> h=getMazePaths(sr,sc+1,dr,dc);
            for(String s:h){
                mres.add("h"+s);
            }
        }

        if(sr+1<=dr){
            ArrayList<Integer> v=getMazePaths(sr+1,sc,dr,dc);
            for(String s:v){
                mres.add("v"+s);
            }
        }
        return mres;
    }

}