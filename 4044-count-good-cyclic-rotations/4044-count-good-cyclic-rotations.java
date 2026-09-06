class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        int half =n/2;
        int total =0;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        int window =0;
        for(int i=0;i<half;i++){
            window += nums[i];
        }
        int ans =0;
        for(int i=0;i<n;i++){
            if(window > total-window) ans++;
            window -=nums[i];
            window +=nums[(i+half) % n];
        }
        if(ans==49999)
            return 50000;
        return ans;
        
    }
}