import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        printEncodings(str,"");
    }

    public static void printEncodings(String str, String asf) {

        if(str.length()==0){
            System.out.println(asf);
            return;
        }
        if(str.charAt(0)=='0') return;
        String sch=str.substring(0,1);
        String ss=str.substring(1);
        char a=(char)(Integer.valueOf(sch) + 96);
        if(Integer.valueOf(sch)>0){
            printEncodings(ss,asf+a);
        }
        if(str.length()>=2){
            String dch=str.substring(0,2);
            String ds=str.substring(2);
            char b=(char)(Integer.valueOf(dch) + 96);
            if(Integer.valueOf(dch)<=26 && Integer.valueOf(dch)>0){
                printEncodings(ds,asf+b);
            }
        }
    }

}