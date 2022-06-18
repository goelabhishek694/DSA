class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int isP1=-1; int isP2=-1;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int diff=target-num;
            if(map.containsKey(diff)){
                int idx=map.get(diff);
                if(idx!=i){
                    isP1=i;
                    isP2=idx;
                    break;
                }
            }
        }
        int[] ans=new int[2];
        if(isP1!=-1 && isP2!=-1){
            ans[0]=isP1;
            ans[1]=isP2;
        }
        return ans;
    }
}