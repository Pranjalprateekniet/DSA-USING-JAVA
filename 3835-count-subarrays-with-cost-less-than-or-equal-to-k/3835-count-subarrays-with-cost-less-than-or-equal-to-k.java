class Solution {
    public long countSubarrays(int[] arr, long k) {
        int n=arr.length;
        long c=0;
        TreeMap<Integer,Integer>map=new TreeMap<>();
        int left=0;
        int right=0;
        while(right<n){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            
            while(true){
            int min=map.firstKey();
            int max=map.lastKey();
            long cost=1L*(max-min)*(right-left+1);
            if(cost<=k)
                break;
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0)
                    map.remove(arr[left]);
                left++;
            }
            c+=(right-left+1);
            right++;
        }
        return c;
     }
}