class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int num=n;
        int pro=1;
        int temp=n;
        while(temp>0){
            int r=temp%10;
            sum+=r;
            temp/=10;
        }
        while(n>0){
            int r=n%10;
            pro=pro*r;
            n/=10;

        }
        if(num%(sum+pro)==0)
            return true;
        return false;
    }
    
}