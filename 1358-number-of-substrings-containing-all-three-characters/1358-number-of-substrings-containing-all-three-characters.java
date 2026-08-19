class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int right=0;
        int c=0;
        int lastseen[]={-1,-1,-1};
        while(right<n){
            char ch=s.charAt(right);
            lastseen[ch-'a']=right;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                c=c+1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
            }
            right++;

        }
        return c;
    }
}