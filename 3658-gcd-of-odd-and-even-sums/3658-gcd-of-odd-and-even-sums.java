class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd=0;
        int sumeven=0;
        int odd=1;
        int even =2;
        int ans=1;
        for(int i=1;i<=n;i++){
            sumodd+=odd;
            sumeven+=even;
            odd+=2;
            even+=2;
        }
        int limit=Math.min(sumodd,sumeven);
        for(int i=1;i<=limit/2;i++){
            if(sumodd%i==0 && sumeven%i==0){
                ans=i;
            }
        }
        return ans;
    }
}