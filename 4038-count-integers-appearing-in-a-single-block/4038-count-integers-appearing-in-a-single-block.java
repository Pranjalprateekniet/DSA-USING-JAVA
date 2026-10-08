class Solution {
    public int countSpecialIntegers(int[] arr) {
        int c[]=new int[101];
        int res=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(i==0 || arr[i-1]!=arr[i])
                c[arr[i]]++;
        }
        for(int x : c){
            if(x==1)
                res++;
        }
        return res;
    }
}