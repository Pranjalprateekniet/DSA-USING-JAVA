class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=0;
        int curr=0;
        int left=0;
        int right=0;
        while(right<n){
            int key=arr[right];
                map.put(key,map.getOrDefault(key,0)+1);
                while(map.get(arr[right])>k){
                    map.put(arr[left],map.get(arr[left])-1);
                    if(map.get(arr[left])==0)
                        map.remove(arr[left]);
                    left++;
                }
                max=Math.max(max,right-left+1);
                right++;

        }
        return max;

    }
}