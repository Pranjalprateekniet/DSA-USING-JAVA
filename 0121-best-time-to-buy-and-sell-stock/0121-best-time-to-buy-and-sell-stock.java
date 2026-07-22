class Solution {
    public int maxProfit(int[] arr) {
       int buy=arr[0];
       int n=arr.length;
       int profit=0;
       for(int i=1;i<n;i++){
        if(arr[i]<buy){
            buy=arr[i];
        }
        if(arr[i]>buy)
        {
            profit=Math.max(profit,arr[i]-buy);
        }
       }
       return profit;
    }
}