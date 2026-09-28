class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int max=0;
        for(char ch : s.toCharArray()){
            if(ch==')'){
                depth--;
                continue;
            }
            if(ch!='('){
                continue;
            }
            depth++;
            max=Math.max(depth,max);
        }
        return max;
    }
}