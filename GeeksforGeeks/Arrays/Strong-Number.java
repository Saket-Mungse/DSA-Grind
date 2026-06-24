class Solution {
    public boolean isStrong(int n) {
        int[] storage = new int[10];
        storage[0] = 1;
        storage[1] = 1;
        int dup = n;
        int sum = 0;
        while(dup!=0){
            int last = dup%10;
            if(storage[last]==0){
                int fact = findFact(last);
                storage[last] = fact;
            }
            sum+=storage[last];
            dup = dup/10;
        }
        return sum==n;
    }
    
    private int findFact(int n){
        if(n>1){
            int factorial = 1;
            while(n!=1){
                factorial*=n--;
            }
            return factorial;
        }else{
            return 1;
        }
    }
}