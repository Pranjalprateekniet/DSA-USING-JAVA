class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        func(0,0,n,sb,res);
        return res;
    }
    private void func(int open,int close,int n,StringBuilder temp,List<String>res){
        if(open==n && close==n)
            {
                res.add(temp.toString());
                return;
            }
        if(open<n){
            temp.append("(");
            func(open+1,close,n,temp,res);
            temp.deleteCharAt(temp.length() - 1);
        }
        if(close<open){
            temp.append(")");
            func(open,close+1,n,temp,res);
            temp.deleteCharAt(temp.length() - 1);
        }
        return;
    }
}