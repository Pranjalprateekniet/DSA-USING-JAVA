class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int r=source[0]+source[1];
        int c=target[0]+target[1];
        if((r%2)!=(c%2))
            return -1;
        if(((source[0]+source[1])==(target[0]+target[1]))||((source[0]-source[1])==(target[0]-target[1])))
            return 1;
        return 2;
    }
}