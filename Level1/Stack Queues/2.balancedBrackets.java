import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str=scn.nextLine();
       boolean ans=balancedBrackets(str);
       System.out.println(ans);
    }

    public static boolean balancedBrackets(String str){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(i);
            }
            else if(ch==')' || ch==']' || ch=='}'){
                if(st.size()==0) return false;
                if((str.charAt(st.peek())=='(' && ch==')') || (str.charAt(st.peek())=='[' && ch==']') || (str.charAt(st.peek())=='{' && ch=='}')){
                st.pop();
                }
                else return false;
            }
        }
        return st.size()>0?false:true;
    }
}