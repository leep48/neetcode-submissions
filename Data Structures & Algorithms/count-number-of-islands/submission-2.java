class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    search(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    // recursive helper function
    public void search(char[][] grid, int row, int col, int maxRows, int maxCols) {
        // base case
        if (row >= maxRows || row < 0 || col >= maxCols || col < 0 || grid[row][col] == '0') {
            return;
        }

        // set visited element to 0
        grid[row][col] = '0';

        // recursively call search, checking 4 sides
        search(grid, row, col-1, maxRows, maxCols); // top
        search(grid, row, col+1, maxRows, maxCols); // bottom
        search(grid, row-1, col, maxRows, maxCols); // left
        search(grid, row+1, col, maxRows, maxCols); // bottom
        return;
    }
}
