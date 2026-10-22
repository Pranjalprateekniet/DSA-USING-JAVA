class Solution {
    public int minOperations(int[] arr) {
        int n=arr.length;
        int pos=0;
        while(arr[pos]!=0)
            pos++;
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<n-1;i++){
            if(arr[(pos+i)%n]+1 !=arr[(pos+i+1)%n])
                inc=false;
            if(arr[(pos-i+n)%n]+1 !=arr[(pos-i-1+n)%n])
                dec=false;
            
        }
        if(inc)
            return Math.min(pos,1+n-pos+1);
        if(dec)
            return Math.min(1+n-pos-1,pos+2);
        return -1;
    }
}