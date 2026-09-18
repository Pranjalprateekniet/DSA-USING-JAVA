class Solution {
    public int countConsistentStrings(String allowed, String[] arr) {
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        int n=arr.length;
        int c=0;
        for(int i=0;i<n;i++){
            String s=arr[i];
            int j=0;

            while(j<s.length()){
                char ch=s.charAt(j);
                if(!set.contains(ch))
                    break;
                j++;
            }
            if(j==s.length())
                c++;
            
        }
        return c;
    }
}