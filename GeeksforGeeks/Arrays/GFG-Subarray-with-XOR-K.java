import java.util.HashMap;

class Solution {
    public long subarrayXor(int nums[], int k) {
        // Map to store frequency of prefix XORs
        HashMap<Integer, Integer> map = new HashMap<>();
        int currXor = 0;
        int count = 0;
        
        // Base case: prefix XOR 0 appears once
        map.put(0, 1);
        
        for(int num : nums) {
            currXor ^= num;
            
            // If (currXor ^ k) exists in map, it means there exists 
            // a prefix subarray whose XOR with the current prefix results in k
            int target = k ^ currXor;
            count += map.getOrDefault(target, 0);
            
            // Store the current prefix XOR in the map
            map.put(currXor, map.getOrDefault(currXor, 0) + 1);
        }
        return (long) count;
    }
}