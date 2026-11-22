class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                if(set.contains('b'))
                    return false;
            }
            else 
                set.add('b');
        }
        return true;
    }
}