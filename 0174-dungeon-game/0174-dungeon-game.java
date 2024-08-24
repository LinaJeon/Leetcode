class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];

        for (int i = r - 1; i >= 0; --i) {
            for (int j = c - 1; j >= 0; --j) {
                if (i == r - 1 && j == c - 1) { // Bottom-right corner
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == r - 1) { // Last row
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == c - 1) { // Last column
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else { // Rest of the grid
                    dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}
