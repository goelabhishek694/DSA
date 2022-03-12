import java.io.*;
import java.util.*;

public class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        infixConversions(exp);
        // code
    }

    public static void infixConversions(String str){
        Stack<String> prefix=new Stack<>();
        Stack<String> postfix=new Stack<>();
        Stack<Character> operators=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z'){
                prefix.push(ch+"");
                postfix.push(ch+"");
            }

            else if(ch=='('){
                operators.push(ch);
            }
            else if(ch==')'){
                while(operators.peek()!='('){
                    char op=operators.pop();

                    String prev2=prefix.pop();
                    String prev1=prefix.pop();
                    prefix.push(op+prev1+prev2);

                    String postv2=postfix.pop();
                    String postv1=postfix.pop();
                    postfix.push(postv1+postv2+op);

                }
                operators.pop();
            }

            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(operators.size()>0 && operators.peek()!='(' && precedence(ch)<=precedence(operators.peek())){
                    char op=operators.pop();

                    String prev2=prefix.pop();
                    String prev1=prefix.pop();
                    prefix.push(op+prev1+prev2);

                    String postv2=postfix.pop();
                    String postv1=postfix.pop();
                    postfix.push(postv1+postv2+op);
                }
                operators.push(ch);
            }
        }

        while(operators.size()>0){
            char op=operators.pop();

            String prev2=prefix.pop();
            String prev1=prefix.pop();
            prefix.push(op+prev1+prev2);

            String postv2=postfix.pop();
            String postv1=postfix.pop();
            postfix.push(postv1+postv2+op);

        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }

    public static int precedence(char ch){
        if(ch=='+' || ch=='-') return 1;
        if(ch=='*' || ch=='/') return 2;
        return 0;
    }
}