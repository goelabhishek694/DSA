import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        int ans=getSubsequence(str);
        System.out.println(ans);
    }

    public static int getSubsequence(String str){
        int countA=0;
        int countB=0;
        int countC=0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                countA=2*countA+1;
            }
            else if(str.charAt(i)=='b'){
                countB=2*countB+countA;
            }
            else if(str.charAt(i)=='c'){
                countC=2*countC+countB;
            }
        }
        return countC;
    }
}