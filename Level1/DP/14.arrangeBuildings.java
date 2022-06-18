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

// gfg
// https://www.geeksforgeeks.org/count-possible-ways-to-construct-buildings/
class Solution
{
    public int TotalWays(int N)
    {
        
        long oldB=1;
        long oldS=1;
        long mod=1000000007;
        for(int i=2;i<=N;i++){
            
            long newS=(oldB+oldS)%mod;
            long newB=oldS%mod;
            
            oldB=newB;
            oldS=newS;
            
        }
        long ans=(oldB+oldS)%mod;
        return (int)((ans*ans)%mod);
    }
}