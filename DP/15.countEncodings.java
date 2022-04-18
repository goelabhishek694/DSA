import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();

        int count=countEncodings(str);
        System.out.println(count);
    }

    public static int countEncodings(String str){
        int[] dp=new int[str.length()+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<dp.length;i++){
            char ch1=str.charAt(i-2);
            char ch2=str.charAt(i-1);

            if(ch1=='0' && ch2=='0'){
                dp[i]=0;
            }
            else if(ch1=='0' && ch2!='0'){
                dp[i]=dp[i-1];
            }
            else if(ch1!='0' && ch2=='0'){
                if(ch1<='2'){
                     dp[i]=dp[i-2];
                }3
            }
            else{
                if(ch1<='2' && ch2<='6'){
                    dp[i]+=dp[i-2];
                }
                dp[i]+=dp[i-1];
            }
        }

        return dp[str.length()];
    }
}