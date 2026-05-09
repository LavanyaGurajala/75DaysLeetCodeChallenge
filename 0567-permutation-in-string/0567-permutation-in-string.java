class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        int[] a = new int[26];
        int[] b = new int[26];

        // Frequency of s1
        for(int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if(matches(a, b))
            return true;

        // Sliding window
        for(int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            b[s2.charAt(i) - 'a']++;

            // Remove old character
            b[s2.charAt(i - s1.length()) - 'a']--;

            if(matches(a, b))
                return true;
        }

        return false;
    }

    public boolean matches(int[] a, int[] b) {

        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i])
                return false;
        }

        return true;
    }
}