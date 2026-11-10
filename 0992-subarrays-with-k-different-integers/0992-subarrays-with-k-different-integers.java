class Solution {
    private int atmost(int arr[],int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        int result=0;
        for(int right=0;right<arr.length;right++){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            if(map.get(arr[right])==1)
                k--;
            while(k<0){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0)
                    k++;
                left++;
            }
            result+=right-left+1;
        }
        return result;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
}