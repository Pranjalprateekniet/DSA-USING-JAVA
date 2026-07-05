class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int pref[]=new int[m+1];
        Arrays.fill(pref,Integer.MAX_VALUE);
        pref[0]=-1;
        int j=0;
        for(int i=0;i<n && j<m;i++){
            if(t.charAt(i)==s.charAt(j))
                    pref[++j]=i;
        }

        if(j==m)
            return true;
        int[] suff=new int [m+1];
        Arrays.fill(suff,-1);
        suff[m]=n;
        j=m-1;
        for(int i=n-1;i>=0 && j>=0;i--){
            if(t.charAt(i)==s.charAt(j))
                    suff[j--]=i;
        }
        for(int i=0;i<m;i++){
            if(pref[i]!=Integer.MAX_VALUE && suff[i+1]!=-1 && pref[i]<suff[i+1]-1)
                return true;
        }
        return false;
    }
}