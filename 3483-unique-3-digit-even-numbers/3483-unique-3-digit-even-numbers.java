class Solution {
    public int totalNumbers(int[] arr) {
        if(arr.length<3){
            return 0;
        }
        int n=arr.length;
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                for(int k=0;k<n;k++){
                    if(k==i || j==k)
                        continue;
                    if(arr[i]==0)
                        continue;
                    if(arr[k]%2!=0)
                        continue;
                    int num=arr[i]*100+arr[j]*10+arr[k];
                    if(!set.contains(num))
                        ans++;
                    set.add(num);
                }
            }
        }
        return ans;
    }
}