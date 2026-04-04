class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        ArrayList<Integer> l=new ArrayList<>();

       for(int x: nums){
        l.add(x);
       } 
       l.add(target);
          Collections.sort(l);

        return l.indexOf(target);
    }
}