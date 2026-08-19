class Solution {
    public int totalFruit(int[] arr) {
        int n=arr.length;
        int left=0;
            int right=0;
            int max=0;
            HashMap<Integer,Integer>map=new HashMap<>();
            while (right<n) {
                int key=arr[right];
                map.put(arr[right],map.getOrDefault(arr[right],0)+1);
                if(map.size()>2){
                    while(map.size()>2){
                        map.put(arr[left],map.get(arr[left])-1);
                        if(map.get(arr[left])==0)
                            map.remove(arr[left]);
                        left++;
                    }
                }
                int curr=right-left+1;
                max=Math.max(max, curr);
                right++;
            }
            return max;
    }
}