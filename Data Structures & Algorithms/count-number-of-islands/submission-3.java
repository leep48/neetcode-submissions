class Solution {
    public int numIslands(char[][] grid) {
        // iterate through array, until you find first 1, add to island count
        // use dfs to turn 1s into 0s, signifying you already seen this island
        char[][] copy = grid;
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (copy[i][j] == '1') {
                    islands++;
                    explore(copy, i, j);
                }
            }
        }

        return islands;
    }

    public void explore(char[][] grid, int r, int c) {
        if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0) {
            return;
        }

        if (grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        explore(grid, r + 1, c);
        explore(grid, r - 1, c);
        explore(grid, r, c + 1);
        explore(grid, r, c - 1);

    }
}
