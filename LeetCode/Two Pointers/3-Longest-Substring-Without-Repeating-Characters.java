class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        int max = 1;
        set.add(s.charAt(0));
        while(right!=n && left!=n){
            if(!set.add(s.charAt(right))){
                max = Math.max(max,right-left);
                while(s.charAt(left)!=s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        max = Math.max(max,right-left);
        return max;
    }
}