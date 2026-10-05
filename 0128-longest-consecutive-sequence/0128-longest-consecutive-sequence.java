class Solution {
    public int longestConsecutive(int[] arr) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int longest=0;
        for(int x : set){
            if(!set.contains(x-1)){
                int length=1;
                while(set.contains(x+length))
                    length++;
                longest=Math.max(longest,length);
            }
            
        }
        return longest;
    }
}