class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // prefix [1,x,x,x]
        int prefix = 1;
        output[0] = prefix;
        for (int i = 1; i < n; i++) {
            output[i] = prefix * nums[i - 1];
            prefix = output[i];
        }
        // postfix [x,x,x,1]
        int postfix = 1;
        for (int i = n - 2; i >= 0; i--) {
            postfix *= nums[i+1];
            output[i] *= postfix;
        }

        return output;
    }
}  
