class Solution {
    public int[] twoSum(int[] nums, int target) {
        int m=nums.length;
       // ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(nums[i]+nums[j]==target){
                     return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
}