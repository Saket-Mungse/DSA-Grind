class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m){
            return false;
        }

        int[] sWala = new int[26];
        int[] tWala = new int[26];
        for(int i=0;i<n;i++){
            int sIndex = s.charAt(i)-'a';
            int yIndex = t.charAt(i)-'a';
            sWala[sIndex]+=1;
            tWala[yIndex]+=1;
        }
        return Arrays.equals(sWala,tWala);
    }
}