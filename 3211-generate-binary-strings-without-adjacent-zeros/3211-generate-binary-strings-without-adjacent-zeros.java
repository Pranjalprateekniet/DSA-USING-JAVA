class Solution {
    List<String>result=new ArrayList<>();
    private void backtrack(String s,int n,char prev){
        if(s.length()==n)
        {
            result.add(s);
            return;
        }
        backtrack(s+"1",n,'1');
        if(prev!='0'){
            backtrack(s+"0",n,'0');
        }
    }
    public List<String> validStrings(int n) {
        result.clear();
        backtrack("",n,'1');
        return result;
    }
}