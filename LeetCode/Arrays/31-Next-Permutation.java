class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        // Step 1: Find the break-point
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        
        // Step 2: If no break-point, reverse the whole array
        if(index == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 3: Find the next greater element and swap
        for(int i = n - 1; i > index; i--){
            if(nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }
        
        // Step 4: Reverse the rest
        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}