class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] dp=new int[n][m];
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=matrix[i][j]+dp[i-1][j];
                int ld=matrix[i][j];
                if(j-1>=0)
                    ld=ld+dp[i-1][j-1];
                else
                    ld=Integer.MAX_VALUE;
                int rd=matrix[i][j];
                if(j+1<m)
                    rd=rd+dp[i-1][j+1];
                else
                    rd=Integer.MAX_VALUE;
                dp[i][j]=Math.min(up,Math.min(ld,rd));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min=Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}