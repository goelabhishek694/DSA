import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       String str=scn.nextLine();
       boolean ans=duplicateBrackets(str);
       System.out.println(ans);
    }

    public static boolean duplicateBrackets(String str){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')'){
                if(str.charAt(st.peek())=='(') return true;
                while(!st.empty() && str.charAt(st.peek())!='('){
                    st.pop();
                }
                st.pop();
            }
            else st.push(i);
        }
        return false;
    }

}