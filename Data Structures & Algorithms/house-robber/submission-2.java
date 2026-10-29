class Solution {
    public int rob(int[] nums) {
        // start by robbing house 0 vs house 1
        // in recursive step, rob house +2 or +3 away
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return Math.max(goRob(nums, 0, memo), goRob(nums, 1, memo));
    }

    private int goRob(int[] nums, int house, int[] memo) {
        if (house >= nums.length) return 0;
        if (memo[house] != -1) return memo[house];
        memo[house] = nums[house] + Math.max(goRob(nums, house + 2, memo), goRob(nums, house + 3, memo));
        return memo[house];
    }
}
