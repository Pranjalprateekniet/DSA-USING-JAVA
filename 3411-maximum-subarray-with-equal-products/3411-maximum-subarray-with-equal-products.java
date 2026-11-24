class Solution {
    public int maxLength(int[] arr) {
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            long pro=1;
            long lcm=1;
            long gcd=0;
            for(int j=i;j<n;j++){
                pro*=arr[j];
                gcd=gcd(gcd,arr[j]);
                lcm=lcm(lcm,arr[j]);
                if(pro==gcd*lcm)
                    ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
    private long gcd(long a,long b){
        while(b!=0){
            long temp=b;
            b=a%b;
            a=temp;

        }
        return a;
    }
    private long lcm(long a,long b){
        return (a/gcd(a,b)*b);
        }
}