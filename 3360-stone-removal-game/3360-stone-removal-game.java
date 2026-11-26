class Solution {
    public boolean canAliceWin(int n) {
        return func(n,10);
    }
    private boolean func(int n,int take){
        return n>=take && !func(n-take,take-1);
    }
}