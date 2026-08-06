class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int num=n;num<=100;num++){
            int pro=1;
            int i=num;
            while(i>0){
                int r = i%10;
                pro=pro*r;
                i/=10;
            }
            if(pro%t==0)
                return num;
        }
        return 0;
    }
}