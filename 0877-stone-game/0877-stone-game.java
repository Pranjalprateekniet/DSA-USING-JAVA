class Solution {
    public int isyes(int i, int j, int[] piles, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return piles[i];
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int left = piles[i] - isyes(i + 1, j, piles, dp);
        int right = piles[j] - isyes(i, j - 1, piles, dp);

        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }

    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int num = isyes(0, piles.length - 1, piles, dp);
        if (num >= 0) return true;
        return false;
    }
}