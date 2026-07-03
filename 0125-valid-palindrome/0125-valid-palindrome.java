class Solution {
    public boolean isPalindrome(String s) {
        
        String st = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(st.length()==1 || st.length()==0)
            return true;
        int low=0;
        int high=st.length()-1;
        return reverse(st,low,high);
    }
    private boolean reverse(String s,int low ,int high){
        if(s.charAt(low)!=s.charAt(high))
            return false;
        if(low>=high)
            return true;
        return reverse(s,low+1,high-1);

    }
}