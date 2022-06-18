import java.io.*;
import java.util.*;

public class Main {

  public static class CustomStack {
    int[] data;
    int tos;
    int count;

    public CustomStack(int cap) {
      data = new int[cap];
      tos = -1;

    }

    int size() {
      // write ur code here
      return tos+1;
    }

    void display() {
      // write ur code here
      int size=size();
      if(size>0){
        for(; size>=0;size--){
            System.out.print(data[size]+" ");
        }
      }
    }

    void push(int val) {
      // write ur code here
        int size=size();
        if(size<data.length){
            data[size]=val;
            tos++; 
        }
        else{
            System.out.println("Stack overflow");
        }
    }

    int pop() {
      // write ur code here
        if(size()>0){
            int val=data[tos];
            tos--;
            return val;
        }
        else{
            System.out.println("Stack underflow");   
            return -1;
        }

    }

    int top() {
       // write ur code here
        if(size()>0){
            int val=data[tos];
            return val;
        }
        else{
            System.out.println("Stack underflow");   
            return -1;
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomStack st = new CustomStack(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("display")){
        st.display();
      }
      str = br.readLine();
    }
  }
}