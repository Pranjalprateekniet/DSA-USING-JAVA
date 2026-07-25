class Solution {
    public int maxProduct(int n) {
        int num=n;
        int max=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(num>0){
            int r=num%10;
            max=Math.max(r,max);
            map.put(r,map.getOrDefault(r,0)+1);
            num/=10;

        }
        int smax=0;
        boolean flag=false;
        while(n>0){
            int r=n%10;
            if(r==max){
                if(map.get(r)>1)
                    smax=r;
            }
            else if(r>smax && smax<max){
                smax=r;
            }
            n/=10;
        }
        return max*smax;
    }
}