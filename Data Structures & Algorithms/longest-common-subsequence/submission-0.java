class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // recursive + memo
        // dfs(memo, arr1, arr2, row, col)
        // if (row, col) and arr1[row] == arr2[row]
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(memo, text1, text2, 0, 0);
    }

    private int dfs(int[][] memo, String text1, String text2, int row, int col) {
        if (row == text1.length() || col == text2.length()) return 0;
        if (memo[row][col] != -1) return memo[row][col];
        if (text1.charAt(row) == text2.charAt(col)) {
            memo[row][col] = 1 + dfs(memo, text1, text2, row + 1, col + 1);
        } else {
            memo[row][col] = Math.max(dfs(memo, text1, text2, row + 1, col), dfs(memo, text1, text2, row, col + 1));
        }
        return memo[row][col];
    }
}
