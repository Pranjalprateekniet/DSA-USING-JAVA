class Solution {
    public int calculateScore(int a, int b) {
        int s1=0;
        int s2=0;
        while(a>0){
            s1+=a&1;
            a>>=1;
        }
        while(b>0){
            s2+=b&1;
            b>>=1;
        }
        int ans;
        if(s1>=s2)
            ans=s1*s2;
        else
            ans=s2/s1;
        return ans;
    }
}