class Solution {
    public int[] maxKDistinct(int[] arr, int k) {
        Set<Integer>set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        List<Integer>list=new ArrayList<>(set);
        Collections.sort(list,Collections.reverseOrder());
        int[] result=new int[Math.min(k,list.size())];
        for(int i=0;i<result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}