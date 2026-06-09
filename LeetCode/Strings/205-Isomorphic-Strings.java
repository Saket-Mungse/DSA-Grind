class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.get(t.charAt(i))!=null){
                if(map.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }else{
                if(!set.add(s.charAt(i))){
                    return false;
                }
                map.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}