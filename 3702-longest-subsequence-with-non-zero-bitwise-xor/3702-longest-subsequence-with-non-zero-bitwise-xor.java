class Solution {
    public int longestSubsequence(int[] arr) {
        int xor=0;
        boolean hasnonzero=false;
        for(int x:arr){
            xor^=x;
            if(x!=0)
                hasnonzero=true;
        }
        if(xor!=0)
            return arr.length;
        if(hasnonzero)
            return arr.length-1;
        return 0;
    }
}