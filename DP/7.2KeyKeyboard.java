 import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		//write your code here

        int ans=0;
        for(int i=2;i<=n;){
            if(n%i==0){
                ans+=i;
                n=n/i;
            }
            else{
                i++;
            }
        }
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}