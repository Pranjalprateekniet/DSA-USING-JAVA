class Solution {
    public String removeStars(String s) {
        Stack<Character>st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='*'){
                st.push(ch);
            }
            else{
                st.pop();
            }
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            char ch=st.peek();
            sb.append(ch);
            st.pop();
        }
        sb.reverse();
        return sb.toString();

    }
}