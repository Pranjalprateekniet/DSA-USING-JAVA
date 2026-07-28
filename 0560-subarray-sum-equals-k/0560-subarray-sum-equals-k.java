class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        int sum=0;
        int c=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int remove=sum-k;
            c+=map.getOrDefault(remove,0);
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return c;
    }
}