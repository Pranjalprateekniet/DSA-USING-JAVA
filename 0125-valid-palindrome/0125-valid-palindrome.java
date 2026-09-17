class Solution {
    public boolean isPalindrome(String s) {
        
        String st=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        if(st.length()==1 || st.length()==0)
            return true;
            int n=st.length();
        return reverse(st,0,n-1);
    }
    private boolean reverse(String s,int left,int right){
        if(s.charAt(left)!=s.charAt(right))
            return false;
        if(left>=right)
            return true;
        return reverse(s,left+1,right-1);
    }
}