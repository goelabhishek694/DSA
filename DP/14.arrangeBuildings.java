import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();

    long count =arrangeBuildings(n);
    System.out.println(count*count);
 }

 public static long countarrangeBuildingsBinaryStrings(int n){
     long countB=1;
     long countS=1;
     for(int i=2;i<=n;i++){
         long ncountB=countS;
         long ncountS=countS+countB;

         countS=ncountS;
         countB=ncountB;
     }

     return countB+countS;
 }

}