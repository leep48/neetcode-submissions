class Solution {
    public int numIslands(char[][] grid) {
        // traverse 2d array, run dfs on each one, convert 1s to 0s
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("Checking: " + i + ", " + j);
                    islands++;
                    dfs(i, j, grid);
                } 
            }
        }

        return islands;
    }

    private void dfs(int i, int j, char[][] grid) {
        //System.out.println("DFS: " + i + ", " + j);
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
    }
}
