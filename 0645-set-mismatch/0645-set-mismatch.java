class Solution {
    public int[] findErrorNums(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=1;i<=n;i++){
        int key = map.getOrDefault(i, 0);
        if(key==2)
            ans[0]=i;
        
        else if(key==0)
            ans[1]=i;
        }
        return ans;
    }
}