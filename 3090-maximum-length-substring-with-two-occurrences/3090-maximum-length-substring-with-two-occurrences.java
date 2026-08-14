class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int left=0;
        int max=0;
        int curr=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int right =0;

        while(right<n){
            char ch=s.charAt(right);
            
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                while(map.get(ch)>2){
                    char c=s.charAt(left);
                    map.put(c,map.get(c)-1);
                    left++;
                }
                curr=right-left+1;
                right++;
            max=Math.max(max,curr);
        }
        return max;
    }
}