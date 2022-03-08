import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        ArrayList<String> ans=gss(str);
        // for(String s:ans){
        //     System.out.print(s);
        // }
        System.out.println(ans);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);
        ArrayList<String> ans=gss(ros);
        int size=ans.size();
        for(int i=0;i<size;i++){
            // System.out.println(s+"a");
            ans.add( ch + ans.get(i));
        }
        
        return ans;
    }

}