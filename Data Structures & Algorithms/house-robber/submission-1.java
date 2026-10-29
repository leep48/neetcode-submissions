class Solution {
    public int rob(int[] nums) {
        // start by robbing house 0 vs house 1
        // in recursive step, rob house +2 or +3 away
        int[] memo = new int[nums.length + 3];
        Arrays.fill(memo, -1);
        return Math.max(goRob(nums, 0, memo), goRob(nums, 1, memo));
    }

    private int goRob(int[] nums, int house, int[] memo) {
        if (house >= nums.length) return 0;
        int nextHouse = house + 2;
        int nextNextHouse = house + 3;

        if (memo[nextHouse] == -1) {
            memo[nextHouse] = goRob(nums, nextHouse, memo);
        }

        if (memo[nextNextHouse] == -1) {
            memo[nextNextHouse] = goRob(nums, nextNextHouse, memo);
        }

        return nums[house] + Math.max(memo[nextHouse], memo[nextNextHouse]);
    }
}
