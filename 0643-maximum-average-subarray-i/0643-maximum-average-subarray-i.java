class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int s=0;
        for(int i=0;i<k;i++){
            s+=nums[i];
        }
        int max=s;
        for(int i=k;i<nums.length;i++){
            s+=nums[i];
            s-=nums[i-k];
            max=Math.max(max,s);
        }
        return (double)max/k;
    }
}