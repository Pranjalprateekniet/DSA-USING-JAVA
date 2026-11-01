class Solution {
    public int minMoves(int[] arr) {
        int min=Integer.MAX_VALUE;
        for(int x:arr){
            if(x<min)
                min=x;
            
        }
        long moves=0;
        for(int x : arr )
            moves+=x-min;
        return (int)moves;
    }
}