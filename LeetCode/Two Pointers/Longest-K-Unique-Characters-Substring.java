class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = -1;
        while(right<n){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()<=k){
                if(map.size()==k){
                    max = Math.max(max,right-left+1);   
                }
            }else{
                while(left<=right && map.size()!=k){
                    if(map.get(s.charAt(left))>1){
                        map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    }else{
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
                max = Math.max(max,right-left+1);
            }
            right++;
        }
        return max;
    }
}