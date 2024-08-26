class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // Create a DP table with the same dimensions as dungeon
        int[][] dp = new int[m][n];
        
        // Fill the bottom-right corner
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        
        // Fill the last row (right to left)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
        
        // Fill the last column (bottom to top)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        
        // Fill the rest of the DP table
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minHealthOnExit - dungeon[i][j], 1);
            }
        }
        
        // The result is the minimum initial health needed to start from (0, 0)
        return dp[0][0];
    }
}
