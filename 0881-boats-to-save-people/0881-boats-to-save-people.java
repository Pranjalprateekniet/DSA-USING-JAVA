class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        int n=arr.length;
        Arrays.sort(arr);
        int count=0;
        int right=n-1;
        int left=0;
        while(left<=right){
            int sum=arr[left]+arr[right];
            if(sum<=limit)
            {
                count++;
                left++;
                right--;
            }
            else
            {
                count++;
                right--;
            }
        }
        return count;
    }
}