class Solution {
    public int uniquePaths(int m, int n) {
        // dfs down or right
        // memo # of unique paths to end from current tile
        // fill with -1 meaning not calculated before
        // return dfs(down) + dfs(right)
        // out of bounds, should return 0
        // base case grid[m - 1][n - 1], return 1 (one way to stay in same place)
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return navigate(memo, 0, 0);
    }

    private int navigate(int[][] memo, int y, int x) {
        int m = memo.length;
        int n = memo[0].length;
        if (y >= m || x >= n) return 0;
        if (y == m - 1 && x == n - 1) return 1;
        if (memo[y][x] != -1) return memo[y][x];
        int uniquePaths = navigate(memo, y + 1, x) + navigate(memo, y, x + 1);
        memo[y][x] = uniquePaths;
        return uniquePaths;
    }
}
