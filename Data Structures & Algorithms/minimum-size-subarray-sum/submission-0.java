class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum >= target) {
                result = Math.min(r - l + 1, result);
                sum -= nums[l];
                l++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}