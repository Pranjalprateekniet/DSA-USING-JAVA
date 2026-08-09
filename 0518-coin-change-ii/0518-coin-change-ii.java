class Solution {
    public int change(int amount, int[] arr) {
        int n=arr.length;
        int dp[]=new int[amount+1];
        dp[0]=1;
        int mod=1000000007;
        for(int coins: arr){
            for(int i=coins;i<=amount;i++){
                dp[i]=(dp[i]+dp[i-coins]);
            }
        }
        return dp[amount];
    }
}