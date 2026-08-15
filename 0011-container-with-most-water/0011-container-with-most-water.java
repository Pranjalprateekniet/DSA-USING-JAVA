class Solution {
    public int maxArea(int[] arr) {
        int max=0;
        int left =0;
        int right=arr.length-1;
        while(left<right){
            max=Math.max(max,(right-left)*Math.min(arr[left],arr[right]));
            if(arr[left]<arr[right])
                left++;
            else
                right--;
            
        }
        return max;
    }
}