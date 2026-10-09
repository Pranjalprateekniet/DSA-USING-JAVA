class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open=0;
        int close=0;
        int res=0;
        //here we do left to right traversal checking for a valid substring
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(')
                open++;
            else if(ch==')')
                close++;
            if(open==close)
                res=Math.max(open+close,res);
            else if(close>open)
            {
                open=0;
                close=0;
            }

        }
        // now right to left travsersal
        open=0;
        close=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==')')
                close++;
            else
                open++;
            if(open==close)
                res=Math.max(res,open+close);
            if(open>close)
            {
                open=0;
                close=0;
            } 

        }
        return res;
    }
}