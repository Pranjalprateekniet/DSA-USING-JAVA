class Solution {
    public void reverseString(char[] arr) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}