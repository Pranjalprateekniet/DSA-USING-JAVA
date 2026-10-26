class Solution {
    public int countPairs(List<Integer> arr, int target) {
        int n=arr.size();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=arr.get(i)+arr.get(j);
                if(sum<target)
                    count++;
            }
        }
        return count;
    }
}