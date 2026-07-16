class Solution {
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
            
        }
        return a;
    }

    public long gcdSum(int[] arr) {
        int n=arr.length;
        int[] prefixgcd=new int[n];
        int mx=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,arr[i]);
            prefixgcd[i]=gcd(arr[i],mx);
        }
        Arrays.sort(prefixgcd);
        int left=0;
        int right=n-1;
        long sum=0;
        while(left<right){
            sum+=gcd(prefixgcd[left],prefixgcd[right]);
            left++;
            right--;
        }
        return sum;
    }
}