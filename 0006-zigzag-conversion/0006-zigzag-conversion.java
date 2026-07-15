class Solution {
    public String convert(String s, int num) {
        if(num==1 || num>s.length())
            return s;
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int cycle=2*num-2;
        for(int i=0;i<num;i++){
            int j=i;
            while(j<n){
                sb.append(s.charAt(j));
                if(i!=0 && i!=num-1)
                {
                    int mid=j+cycle-2*i;
                    if(mid<n){
                        sb.append(s.charAt(mid));
                    }
                }
                j+=cycle;
            }
        }
        return sb.toString();
    }
}