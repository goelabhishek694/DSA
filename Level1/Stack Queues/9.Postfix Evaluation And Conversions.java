import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    postfixEvalAndConversions(exp);
    // code
 }

 public static void postfixEvalAndConversions(String str){
     Stack<String> prefix=new Stack<>();
     Stack<String> infix=new Stack<>();
     Stack<Integer> valueStack=new Stack<>();

     for(int i=0;i<str.length();i++){
         char ch=str.charAt(i);
         if(ch>='0' && ch<='9'){
             prefix.push(ch-'0'+"");
             infix.push((ch-'0')+"");
             valueStack.push(ch-'0');
         }
         else if(ch=='+'||ch=='-' || ch=='/' ||ch=='*'){

             String prev2=prefix.pop();
             String prev1=prefix.pop();
             prefix.push(ch+prev1+prev2);

             String inv2=infix.pop();
             String inv1=infix.pop();
             infix.push("("+inv1+ch+inv2+")");

             int v2=valueStack.pop();
             int v1=valueStack.pop();
             int ans=evaluate(v1,v2,ch);
             valueStack.push(ans);

         } 
     }

    //  while(valueStack.size()>0){
    //      int v2=valueStack.pop();
    //          int v1=valueStack.pop();
    //          int ans=evaluate(v1,v2,ch);
    //          valueStack.push(ans);
    //  }

     System.out.println(valueStack.pop());
     System.out.println(infix.pop());
     System.out.println(prefix.pop());
 }

 public static int evaluate(int v1, int v2, char ch){
     if(ch=='+') return v1+v2;
     if(ch=='-') return v1-v2;
     if(ch=='*') return v1*v2;
     if(ch=='/') return v1/v2;
     return 0;
 }
}