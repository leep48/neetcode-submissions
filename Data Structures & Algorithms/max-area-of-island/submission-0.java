class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // traverse 2d array, use dfs to calculate island area
        // seen islands turn into 0
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(j, i, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) {
            return 0;
        }

        if (grid[y][x] == 0) {
            return 0;
        }

        grid[y][x] = 0;

        int top = dfs(x, y - 1, grid);
        int down = dfs(x, y + 1, grid);
        int left = dfs(x - 1, y, grid);
        int right = dfs(x + 1, y, grid);

        return 1 + top + down + left + right;
    }
}
