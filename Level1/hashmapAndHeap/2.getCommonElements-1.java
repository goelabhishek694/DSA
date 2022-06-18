import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    // int[] arr1=new int[n];
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<n;i++){
        // arr1[i]=scn.nextInt();
        int ele=scn.nextInt();
        if(map.containsKey(ele)){
            map.put(ele,map.get(ele)+1);
        }
        else map.put(ele,1);
    }

    int m=scn.nextInt();
    int[] arr2=new int[m];
    for(int i=0;i<m;i++){
        arr2[i]=scn.nextInt();
    }

    for(int i=0;i<m;i++){
        int num=arr2[i];

        if(map.containsKey(num) && map.get(num)>0){
            System.out.println(num);
            // fmap.remove(num);
            map.put(num,0);
        }
    }
 }

}