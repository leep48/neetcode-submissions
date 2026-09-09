class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // expand window until sum >= target
        // keep shifting left pointer until sum < target to find min size
        int minLength = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum+=nums[r];

            while (sum >= target) {
                minLength = Math.min((r - l + 1), minLength);
                sum -= nums[l];
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}