import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.println(cps(str));
    }

    public static int cps(String str){
        int count=0;
        int[][] dp=new int[str.length()][str.length()];
        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<str.length();i++,j++){
                if(gap==0){
                    count++;
                }
                else if(gap==1 && str.charAt(i)==str.charAt(j)){
                    count++;
                }
                else if(str.charAt(i)==str.charAt(j)){
                    count+=(j-i-1);
                }
            }
        }
        return count;
    }

}