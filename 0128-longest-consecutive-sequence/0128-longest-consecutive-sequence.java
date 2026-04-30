import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements
        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(int num : set) {
            // Start only if it's the beginning of sequence
            if(!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}