class Solution {
    public int climbStairs(int n) {
        // run recursive dfs, choosing between 1 or 2 steps
        // calculate total ways by returning [1 step] + [2 step]
        // if > n, return 0
        // if == n, return 1
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climb(n, 0, memo);
    }

    private int climb(int n, int curr, int[] memo) {
        if (curr > n) return 0;
        if (curr == n) return 1;

        if (memo[curr] > -1) {
            return memo[curr];
        }
        memo[curr] = climb(n, curr + 1, memo) + climb(n, curr + 2, memo);

        return memo[curr];
    }


}
