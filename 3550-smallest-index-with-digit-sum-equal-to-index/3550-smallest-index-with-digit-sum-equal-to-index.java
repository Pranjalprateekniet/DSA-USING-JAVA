class Solution {
    public int smallestIndex(int[] arr) {
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int num=arr[i];
            int sum=0;
            while(num>0){
                int r=num%10;
                sum+=r;
                num/=10;
            }
            if(sum==i)
                min=Math.min(min,i);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}