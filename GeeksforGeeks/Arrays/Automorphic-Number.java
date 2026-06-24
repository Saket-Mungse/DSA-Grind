class Solution {
    public String isAutomorphic(int n) {
        int square = n*n;
        while(n!=0 && square!=0){
            int lastN = n%10;
            int lastS = square%10;
            if(lastN!=lastS){
                return "Not Automorphic";
            }
            n = n/10;
            square = square/10;
        }
        return "Automorphic";
    }
}