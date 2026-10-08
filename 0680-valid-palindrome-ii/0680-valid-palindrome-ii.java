class Solution {
    public boolean validPalindrome(String s) {
        int count=0;
        int left=0;
        int right=s.length()-1;
        while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            return func(s,left+1,right)||func(s,left,right-1);
        }
        left++;
        right--;
        }
        return true;
    }
    private boolean func(String s,int left,int right)
    {
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}