class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer>r=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int in=Math.abs(nums[i])-1;
            if(nums[in]>0){
                nums[in]=-nums[in];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                r.add(i+1);
            }
        }
        return r;
    }
}