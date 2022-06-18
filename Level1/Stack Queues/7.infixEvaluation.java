import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    int ans=infixEvaluation(exp);
    System.out.println(ans);

    // code
 }

public static int infixEvaluation(String str){
    Stack<Integer> operands=new Stack<>();// pushing num
    Stack<Character> operators=new Stack<>(); //puhsing index
    // System.out.println(str.length());
    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        if(ch>='0' && ch<='9'){
            operands.push(ch-'0');
            // System.out.println(operands.peek());
        }
        else if(ch=='(') operators.push(ch);
        else if(ch==')'){
            while(operators.peek()!='('){
               char op=operators.peek();
               int a=operands.pop();
               int b=operands.pop();

               int ans=evaluate(b,a,op);
               operands.push(ans);

            }
            operators.pop();
        }
        else if( ch=='+' || ch=='-' || ch=='*' || ch=='/'){ //  +, -, *, /
            while(operators.size()>0 && operators.peek()!='(' && getPrecedence(ch)<=getPrecedence(operators.peek())){
               char op=operators.pop();
            //    System.out.println(op);
               int a=operands.pop();
               int b=0;
               if(operands.size()>0) b=operands.pop();

               int ans=evaluate(b,a,op);
            //    System.out.println("evaluated ans is "+ans);
               operands.push(ans);

            }
            operators.push(ch);
            // System.out.println(operators.peek());
        }
    }

     while(operators.size()>0 ){
        char op=operators.pop();
        int a=operands.pop();
        int b=0;
        if(operands.size()>0) b=operands.pop();

        int ans=evaluate(b,a,op);
        operands.push(ans);

    }

    return operands.pop();

    
}

public static int evaluate(int b, int a, char ch){
    if(ch=='+') return b+a;
    if(ch=='-') return b-a;
    if(ch=='*') return b*a;
    if(ch=='/') return b/a;
    return 2;
}

 public static int getPrecedence(char ch){
     if(ch=='+' || ch=='-'){
         return 0;
     }
     if(ch=='/' || ch=='*'){
         return 1;
     }
     return 2;
 }
}