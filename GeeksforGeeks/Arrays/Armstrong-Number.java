class Solution {
    static boolean armstrongNumber(int num) {
        // Pre-calculate cubes of digits 0-9
        int[] cubes = new int[10];
        for (int i = 0; i < 10; i++) {
            cubes[i] = i * i * i;
        }
        
        int sum = 0;
        int dup = num;
        
        // Sum the cubes of each digit
        while (dup != 0) {
            int digit = dup % 10;
            sum += cubes[digit];
            dup /= 10;
        }
        
        return num == sum;
    }
}