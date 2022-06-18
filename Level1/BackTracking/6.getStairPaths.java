import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        ArrayList<String> res=getStairPaths(n);
        System.out.println(res);
        
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> bres= new ArrayList<String>();
            bres.add("");
            return bres;
        }
        ArrayList<String> mres=new ArrayList<>();
        for(int i=1;i<=3;i++){
            if(n-i>=0){
                ArrayList<String> ans=getStairPaths(n-i);
                for(String s:ans){
                    mres.add(i+s);
                }
            }
        }
        return mres;
    }

}