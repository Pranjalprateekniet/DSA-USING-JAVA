class Solution {
    public int countGoodSubstrings(String s) {

        int left=0;
        int right=2;
        int n=s.length();
        if(n<3)
            return 0;
        HashMap<Character,Integer>map=new HashMap<>();
        map.put(s.charAt(0),1);
        map.put(s.charAt(1),map.getOrDefault(s.charAt(1),0)+1);

        int c=0;
        while(right<n){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()==3)
                c++;
            map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
            if(map.get(s.charAt(left))==0)
                map.remove(s.charAt(left));
            left++;
            right++;
        }
        return c;
    }
}