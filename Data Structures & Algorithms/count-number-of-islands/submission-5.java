class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int sr, int sc) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;
            if (grid[r][c] != '1') continue;

            grid[r][c] = '0';

            queue.offer(new int[] {r + 1, c});
            queue.offer(new int[] {r - 1, c});
            queue.offer(new int[] {r, c + 1});
            queue.offer(new int[] {r, c - 1});
        }
    }
}
