class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n=days.length;
        int dp[] = new int[n + 1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int j = i;

    while (j < n && days[j] < days[i] + 1) {
        j++;
    }
    int j7=i;
    while (j7 < n && days[j7] < days[i] + 7) {
        j7++;
    }
    int j30=i;
    while (j30 < n && days[j30] < days[i] + 30) {
        j30++;
    }
                int c1=cost[0]+dp[j];
                int c2=cost[1]+dp[j7];
                int c3=cost[2]+dp[j30];
                dp[i]=Math.min(c1,Math.min(c2,c3));
            
        }
        return dp[0];
    }
}