public class twosumsorted {
    public int[] twoSum(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while (low<high){
            int sum=nums[low]+nums[high];
            if(sum>target){
                high--;
            }
            else if(sum<target){
                low++;
            }
            else if(sum==target){
                return new int[]{low,high};
            }
        }
        return new int[] {-1,-1};
}
}
