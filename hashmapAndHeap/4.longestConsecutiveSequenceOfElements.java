import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
    }
    HashMap<Integer,Boolean> map=new HashMap<>();
    for(int i=0;i<n;i++){
        map.put(arr[i],true);
    }

    for(int i=0;i<n;i++){
        if(map.containsKey(arr[i]-1)){
            map.put(arr[i],false);
        }
    }

    int maxLen=0;
    int maxStartingPoint=0;

    for(int i=0;i<n;i++){
        if(map.get(arr[i])==true){
            int tempLen=1;
            int tempStartingPoint=arr[i];
            while(map.containsKey(tempStartingPoint+tempLen)){
                tempLen++;
            }

            if(tempLen>maxLen){
                maxLen=tempLen;
                maxStartingPoint=tempStartingPoint;
            }
        }
    }

    for(int i=maxStartingPoint;i<maxStartingPoint+maxLen;i++){
        System.out.println(i);
    }
 }

}

// leetcode 128

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        
        for(int ele:nums){
            if(map.containsKey(ele-1)){
                map.put(ele,0);
            }
        }
        int maxLen=1;
        for(int ele:nums){
            if(map.containsKey(ele) && map.get(ele)==1){
                int tempLen=1;
                int tempStartPoint=ele;
                
                while(map.containsKey(tempLen+tempStartPoint)){
                    tempLen++;
                }
                maxLen=Math.max(maxLen,tempLen);
            }
        }
        
        return maxLen;
    }
}