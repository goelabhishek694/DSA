import java.io.*;
import java.util.*;

public class Main{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        prefixEvaluationAndConversions(exp);
    // code
    }

    public static void prefixEvaluationAndConversions(String str){
        Stack<String> infix=new Stack<>();
        Stack<String> postfix=new Stack<>();
        Stack<Integer> valueStack=new Stack<>();

        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch>='0' && ch<='9'){
                infix.push(ch-'0'+"");
                postfix.push(ch-'0'+"");
                valueStack.push(ch-'0');
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                String inv1=infix.pop();
                String inv2=infix.pop();
                infix.push("("+inv1+ch+inv2+")");

                String postv1=postfix.pop();
                String postv2=postfix.pop();
                postfix.push(postv1+postv2+ch);

                int v1=valueStack.pop();
                int v2=valueStack.pop();
                int ans=evaluate(v1,v2,ch);
                valueStack.push(ans);
            }
        }
        System.out.println(valueStack.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());

    }
    public static int evaluate(int v1, int v2, char ch){
     if(ch=='+') return v1+v2;
     if(ch=='-') return v1-v2;
     if(ch=='*') return v1*v2;
     if(ch=='/') return v1/v2;
     return 0;
 }

}