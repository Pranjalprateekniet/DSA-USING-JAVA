class Solution {
    public int subarraysWithKDistinct(int[] arr, int k) {
        return atmostk(arr,k)-atmostk(arr,k-1);
    }
    private static int atmostk(int arr[],int k){
        int n=arr.length;
        int left=0;
        int right=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=0;
        while(right<n){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>k){
                map.put(arr[left],map.getOrDefault(arr[left],0)-1);
                if(map.get(arr[left])==0)
                    map.remove(arr[left]);
                left++;
            }
            max+=right-left+1;
            right++;
        }
        return max;
    }
}