class Solution {
    public int sumCounts(List<Integer> arr) {
        int sum=0;
        int right=0;
        int n=arr.size();
        while(right<n){
            HashSet<Integer>set=new HashSet<>();
            for(int j=right;j<n;j++){
                set.add(arr.get(j));
                int m=set.size();
                sum+=(m*m);
            }
            right++;
        }
        return sum;
    }
}