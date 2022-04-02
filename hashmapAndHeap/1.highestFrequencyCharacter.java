import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else {
                map.put(ch,1);
            }
        }

        char ch=str.charAt(0);
        int count=Integer.MIN_VALUE;
        for(Character cha:map.keySet()){
            if(map.get(cha)>count){
                count=map.get(cha);
                ch=cha;
            }
        }
        System.out.println(ch);
    }

}