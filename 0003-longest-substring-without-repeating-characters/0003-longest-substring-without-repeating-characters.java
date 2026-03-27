class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer>m=new HashMap<>();
        int l=0;
        int max=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            if(m.containsKey(ch)&&m.get(ch)>=l){
                l=m.get(ch)+1;
            }
            m.put(ch,r);
            max=Math.max(max,r-l+1);
        }
        return max;
        
    }
}