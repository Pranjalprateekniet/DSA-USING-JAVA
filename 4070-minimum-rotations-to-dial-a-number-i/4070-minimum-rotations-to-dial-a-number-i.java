class Solution {
    public int minRotations(String s) {
        int cur=0;
        int res=0;
        for(char c :  s.toCharArray()){
            int digit=c-'0';
            int d=(digit-cur+10)%10;
            res+=Math.min(d,10-d);
            cur=digit;
        }
        return res;
    }
}