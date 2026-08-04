class Solution {
    public int countValidPrefixes(String s) {
        int n=s.length();
        int zero=0;
        int one =0;
        int c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='1')
                one++;
            else
                zero++;
            int diff=Math.abs(one-zero);
            if(diff==0 || diff==1)
            c++;
        }
        
        return c;
    }
}