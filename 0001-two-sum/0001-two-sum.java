class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int need=target-nums[i];
            if(hm.containsKey(need)){
                return new int[]{hm.get(need),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{};
    }
}