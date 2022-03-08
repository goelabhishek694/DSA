import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        ArrayList<String> ans=getKPC(str);
        System.out.println(ans);
    }
    static String[] codes={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }
        char ch=str.charAt(0); 
        String ros=str.substring(1);
        ArrayList<String> ans=getKPC(ros);
        int size=ans.size();
        ArrayList<String> mres = new ArrayList<String>();
        for(int j=0;j<codes[ch-'0'].length();j++){
            for(int i=0;i<size;i++){
                String s=ans.get(i);
                

                mres.add(codes[ch-'0'].charAt(j)+s);
            }
        }
        // System.out.println(mres);
        return mres;
    }

}