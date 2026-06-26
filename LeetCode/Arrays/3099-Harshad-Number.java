class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int n = x;
        int sum = 0;
        while(n>0){
            int lastDigit = n%10;
            sum+=lastDigit;
            n = n/10;
        }
        return x%sum==0?sum:-1;
    }
}