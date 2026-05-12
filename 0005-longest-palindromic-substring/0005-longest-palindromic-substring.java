class Solution {
    public String longestPalindrome(String s) {
        int st=0;
        int e=0;
        for(int i=0;i<s.length();i++){
            int l=i;
            int r=i;
            while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
              if(r-l>e-st){

              st=l;
              e=r;
            }
            l--;
            r++;

        }
         l=i;
         r=i+1;
         while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            if(r-l>e-st){
                st=l;
                e=r;
            }
            l--;
            r++;
         }
         
    }
    return s.substring(st,e+1);
    }
}