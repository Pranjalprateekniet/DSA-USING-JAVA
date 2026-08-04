class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(!set.contains(arr[i]))
                set.add(arr[i]);
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);

        }
        for(int i=min;i<=max;i++){
            if(!set.contains(i))
                list.add(i);

        }
        return list;
    }
}