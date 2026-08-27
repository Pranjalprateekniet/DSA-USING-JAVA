class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if(arr.length==0 || k==0)
            return new int[0];
        int n=arr.length;
        int[] result=new int[n-k+1];
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++){
            if(i%k==0)
                left[i]=arr[i];
            else
                left[i]=Math.max(left[i-1],arr[i]);
            int temp=(i/k+1)*k-1;
            if(temp>n-1)
                temp=n-1;
            int j=temp-i%k;
            if(j%k==(k-1) || j==n-1)
                right[j]=arr[j];
            else
                right[j]=Math.max(right[j+1],arr[j]);
        }
        for(int i=0,j=i+k-1;j<n;++i,++j)
            result[i]=Math.max(right[i],left[j]);
        return result;
    }
}