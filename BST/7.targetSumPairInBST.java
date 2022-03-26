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

  public static boolean find (Node node, int data){
      if(node==null) return false;
      if(data<node.data){
          return find(node.left,data);
      }
      else if(data>node.data){
          return find(node.right,data);
      }
      else return true;
  }

//   public static void targetSumPair(Node ogn,Node node, int data){
//       if(node==null) return;
      
//       targetSumPair(ogn,node.left,data);
//       int comp=data-node.data;
//       if(node.data!=comp){
//         if(find(og,comp)){
//             System.out.println(node.data+" "+comp);
//         }
//       }
//       targetSumPair(ogn,node.right,data);

//   }

public static class IntPair{
    Node node;
    int state;

    IntPair(Node node, int state){
        this.node=node;
        this.state=state;
    }
}

public static void bestApproach(Node node, int tar){
    Stack<IntPair> ls=new Stack<>();
    Stack<IntPair> rs=new Stack<>();

    ls.push(new IntPair(node,0));
    rs.push(new IntPair(node,0));

    int left=inorderLeft(ls);
    int right=inorderRight(rs);

    while(left<right){
        if(left+right<tar){
            left=inorderLeft(ls);
        }
        else if(left+right>tar){
            right=inorderRight(rs);
        }
        else {
            System.out.println(left+" "+right);
            left=inorderLeft(ls);
            right=inorderRight(rs);
        }
    }
}

public static int inorderLeft(Stack<IntPair> st){
    while(st.size()>0){
        IntPair rp=st.peek();
        if(rp.state==0){
            if(rp.node.left!=null){
                st.push(new IntPair(rp.node.left,0));
            }
            rp.state++;
        }
        else if(rp.state==1){
            if(rp.node.right!=null){
                st.push(new IntPair(rp.node.right,0));
            }
            rp.state++;
            return rp.node.data;
        }
        if(rp.state==2){
            st.pop();
        }
    }
    return 0;
}

public static int inorderRight(Stack<IntPair> st){
    while(st.size()>0){
        IntPair rp=st.peek();
        if(rp.state==0){
            if(rp.node.right!=null){
                st.push(new IntPair(rp.node.right,0));
            }
            rp.state++;
        }
        else if(rp.state==1){
            if(rp.node.left!=null){
                st.push(new IntPair(rp.node.left,0));
            }
            rp.state++;
            return rp.node.data;
        }
        if(rp.state==2){
            st.pop();
        }
    }
    return 0;
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    // write your code here
    // targetSumPair(root,root,data);
    bestApproach(root,data);
  }

}