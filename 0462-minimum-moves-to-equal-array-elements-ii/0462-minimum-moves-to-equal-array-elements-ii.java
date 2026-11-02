class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int median=arr[arr.length/2];
        long moves=0;
        for(int num :  arr)
            moves+=Math.abs(num-median);
        return (int)moves;
    }
}