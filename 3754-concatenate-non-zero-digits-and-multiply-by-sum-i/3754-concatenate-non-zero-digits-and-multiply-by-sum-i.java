class Solution {
    public long sumAndMultiply(int n) {
        long num=0;
        long sum=0;
        while(n>0){
            long r=n%10;
            if(r!=0){
                num=num*10+r;
                sum+=r;
            }
            n/=10;
        }
        long reverse=0;
        while(num>0){
            long r=num%10;
            reverse=reverse*10+r;
            num/=10;
        }

        return (long)sum*reverse;
    }
}