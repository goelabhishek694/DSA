import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static class BSTPair{
    boolean isBST;
    int min;
    int max;
    Node ln;
    int count;
  }

  public static BSTPair largestBSTSubtree(Node node){
    if(node==null){
      BSTPair bres=new BSTPair();
      bres.isBST=true;
      bres.min=Integer.MAX_VALUE;
      bres.max=Integer.MIN_VALUE;
      bres.ln=null;
      bres.count=0;
      return bres;
    }

    BSTPair lst=largestBSTSubtree(node.left);
    BSTPair rst=largestBSTSubtree(node.right);

    BSTPair mp=new BSTPair();
    mp.isBST=lst.isBST && rst.isBST && node.data>=lst.max && node.data<=rst.min;
    mp.min=Math.min(node.data, Math.min(lst.min, rst.min));
    mp.max=Math.max(node.data, Math.max(lst.max, rst.max));
    if(!mp.isBST){
      if(lst.count>rst.count){
        mp.ln=lst.ln;
        mp.count=lst.count;
      }
      else{
        mp.ln=rst.ln;
        mp.count=rst.count;
      } 
    }
    else{
      mp.ln=node;
      mp.count=rst.count+lst.count+1;
    }

    return mp;

  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    BSTPair res=largestBSTSubtree(root);
    System.out.println(res.ln.data+"@"+res.count);
  }

}