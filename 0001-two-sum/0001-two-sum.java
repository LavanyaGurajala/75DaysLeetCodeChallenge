class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer>hm=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int need=target-nums[i];
        if(hm.containsKey(need)){
            return new int[]{hm.get(need),i};
        }
        hm.put(nums[i],i);

      }
      return new int[]{};
    }
}