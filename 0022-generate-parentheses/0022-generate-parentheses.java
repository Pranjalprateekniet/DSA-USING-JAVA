class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder temp=new StringBuilder();
        ArrayList<String> ans=new ArrayList<>();
        func(0,0,n,temp,ans);
        return ans;
    }
    private static void func(int open,int close,int n,StringBuilder temp,List<String>ans){
        if(open==n && close==n)
        {
            ans.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append('(');
            func(open+1,close,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            func(open,close+1,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        return;

    }
}