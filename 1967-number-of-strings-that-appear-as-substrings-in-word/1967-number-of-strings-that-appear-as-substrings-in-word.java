class Solution {
    public int numOfStrings(String[] arr, String word) {
        int n=arr.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(word.contains(arr[i]))
                c++;

        }
        return c;
    }
}