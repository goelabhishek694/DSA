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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

    // public static boolean isBinarySearchTree(int lb, Node node, int ub){
    //     if(node==null) return true;

    //     boolean lbst=isBinarySearchTree(lb,node.left,node.data);
    //     boolean rbst=isBinarySearchTree(node.data,node.right,ub);
    //     if(lbst && rbst){
    //         if(node.data>lb && node.data<ub){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
  public static class bstPair{
    boolean isBST;
    int min;
    int max;
  }

  public static bstPair isBinarySearchTree(Node node){

    if(node==null){
      bstPair resPair=new bstPair();
      resPair.isBST=true;
      resPair.min=Integer.MAX_VALUE;
      resPair.max=Integer.MIN_VALUE;
      return resPair;
    }

    bstPair lbst=isBinarySearchTree(node.left);
    bstPair rbst=isBinarySearchTree(node.right); 

    bstPair myPair=new bstPair();
    myPair.isBST=lbst.isBST && rbst.isBST && lbst.max<=node.data && rbst.min>=node.data;

    myPair.min=Math.min(node.data,Math.min(lbst.min,rbst.min));
    myPair.max=Math.max(node.data,Math.max(lbst.max,rbst.max));

    return myPair;

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
    // boolean res=isBinarySearchTree(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    bstPair res=isBinarySearchTree(root);
    System.out.println(res.isBST);
  }

}