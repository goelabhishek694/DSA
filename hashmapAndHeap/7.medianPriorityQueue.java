import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
        if(right.size()!=0 && val>right.peek()){
            right.add(val);
        }
        else{
            left.add(val);
        }
        //balancing
        if(left.size()-right.size()==2){
            int ele=left.remove();
            right.add(ele);
        }
        else if(right.size()-left.size()==2){
            int ele=right.remove();
            left.add(ele);
        }
    }

    public int remove() {
        if(this.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      if(left.size()>=right.size()){
          return left.remove();
      }
      else return right.remove();
    }

    public int peek() {
      if(this.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      if(left.size()>=right.size()){
          return left.peek();
      }
      else return right.peek();

    }

    public int size() {
      // write your code here
      return left.size()+right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

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


// leetcode 295

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    

    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(right.size()!=0 && num>right.peek()){
            right.add(num);
        }
        else left.add(num);

        //balancing
        if(left.size()-right.size()==2){
          int ele=left.remove();
          right.add(ele);
        }
        else if(right.size()-left.size()==2){
          int ele=right.remove();
          left.add(ele);
        }
    }
    
    public double findMedian() {
        if(right.size()>left.size()){
          return right.peek();
        }
        else if(left.size()>right.size()){
          return left.peek();
        }
        else {
          return (left.peek()+right.peek())/2.0;
        }
    }

}