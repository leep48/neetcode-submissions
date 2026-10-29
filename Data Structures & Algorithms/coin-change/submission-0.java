class Solution {
    public int coinChange(int[] coins, int amount) {
        // dfs on every coin option
        // memo for min coins chosen to get to target amount from current amount
        // stop dfs when current amt > target amt (return 0 ways), and when current == target (return 1 way)
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = dfs(coins, amount, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int[] coins, int amount, int remaining, int[] memo) {
        if (remaining == 0) return 0;
        if (remaining < 0) return Integer.MAX_VALUE;
        if (memo[remaining] != -1) return memo[remaining];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int next = dfs(coins, amount, remaining - coin, memo);
            if (next < Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + next);
            }
        }
        memo[remaining] = minCoins;
        return minCoins;
    }
}
