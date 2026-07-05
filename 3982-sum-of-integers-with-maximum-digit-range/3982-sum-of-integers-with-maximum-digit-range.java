class Solution {
    public int maxDigitRange(int[] arr) {
        int n=arr.length;
        int sum=0;
        int rangearr[]=new int[n];
        int maxrange=0;
        for(int i=0;i<n;i++){
            int num=arr[i];
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            while(num>0){
                int r=num%10;
                max=Math.max(max,r);
                min=Math.min(min,r);
                num/=10;
            }
            int range=max-min;
            rangearr[i]=range;
            maxrange=Math.max(maxrange,range);
            
        }
        for(int i=0;i<n;i++){
            if(rangearr[i]==maxrange)
                    sum+=arr[i];
        }
        return sum;
    }
}