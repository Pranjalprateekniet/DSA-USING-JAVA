class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int ans[]={-1,-1};
        int x1=-1;
        int x2=-1;
        for(int i=0;i<n;i++){
            int need=target-arr[i];
            if(map.containsKey(need) && map.get(need)!=i){
                x1=map.get(need);
                x2=i;
                break;
            }
        }
        int small=Math.min(x1,x2);
        int big=Math.max(x1,x2);
        ans[0]=small;
        ans[1]=big;
        return ans;
        
    }
}