import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1);
    }

    public void upheapify(int ci){
        if(ci==0) return;

        int pi=(ci-1)/2;
        if(data.get(pi)>data.get(ci)){
            swap(ci,pi);
            upheapify(pi);
        }
    }

    public void swap(int a, int b){
      int val1=data.get(a);
      int val2=data.get(b);
        data.set(a,val2);
        data.set(b,val1);
    }

    public int remove() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      
      int val=data.get(0);
      swap(data.size()-1,0);
      data.remove(data.size()-1);
      downheapify(0);
      return val;
    }

    public void downheapify(int pi){
        int mini=pi;

        int li=2*pi+1;
        if(li<data.size() && data.get(mini)>data.get(li)){
            mini=li;
        }

        int ri=2*pi+2;
        if(ri<data.size() && data.get(mini)>data.get(ri)){
            mini=ri;
        }

        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }

    public int peek() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      
      int val=data.get(0);
      return val;
      
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

