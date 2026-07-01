class Solution {
    public boolean detectCapitalUse(String s) {
        int n=s.length();
        int up=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isUpperCase(ch))
                up++;
        }
        if(up==n || up==0 || (up==1&&Character.isUpperCase(s.charAt(0))))
            return true;
        return false;
    }
}