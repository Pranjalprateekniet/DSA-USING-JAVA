class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>ans=new ArrayList<>();
        if(words.length==0 || s.length()==0)
            return ans;
        int wordsize=words[0].length();
        int wordcount=words.length;
        int n=s.length();
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(int i=0;i<wordsize;i++){
            HashMap<String,Integer>cc=new HashMap<>();
            int start=i;
            int count=0;
            for(int end=i;end+wordsize<=n;end+=wordsize){
                String currword=s.substring(end,end+wordsize);
                if(map.containsKey(currword)){
                    cc.put(currword,cc.getOrDefault(currword,0)+1);
                    count++;

                    while(cc.get(currword)>map.get(currword))
                    {
                        String startword=s.substring(start,start+wordsize);
                        cc.put(startword,cc.get(startword)-1);
                        start+=wordsize;
                        count--;
                    }
                    if(count==wordcount)
                        ans.add(start);
                    
                }
                else
                    {
                        count=0;
                        start=end+wordsize;
                        cc.clear();
                    }
            }
        }
        return ans;
    }
}