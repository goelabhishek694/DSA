import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();

    int count =countBinaryStrings(n);
    System.out.println(count);
 }

 public static int countBinaryStrings(int n){
     int count0=1;
     int count1=1;
     for(int i=2;i<=n;i++){
         int ncount0=count1;
         int ncount1=count0+count1;

         count0=ncount0;
         count1=ncount1;
     }

     return count0+count1;
 }

}