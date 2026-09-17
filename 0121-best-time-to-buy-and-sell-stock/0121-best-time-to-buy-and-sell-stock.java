class Solution {
    public int maxProfit(int[] arr) {
        int buy=arr[0];
        int profit =0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]>buy)
            {
                profit=Math.max(profit,arr[i]-buy);
            }
            else{
                buy=arr[i];
            }
        }
        return profit;
    }
}