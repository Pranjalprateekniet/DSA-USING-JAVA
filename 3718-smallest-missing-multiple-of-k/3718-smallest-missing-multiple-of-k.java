class Solution {
    public int missingMultiple(int[] arr, int k) {
        HashSet<Integer>set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            set.add(arr[i]);

        }
        int c=1;
        for(int i=1;i<=200;i++){
            int num=k*c;
            if(!set.contains(num))
                return num;
            c++;
        }
        return 0;
    }
}