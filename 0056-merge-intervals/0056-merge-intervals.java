class Solution {
    public int[][] merge(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]>ans=new ArrayList<>();
        int start =arr[0][0];
        int end=arr[0][1];
        for(int i=1;i<n;i++){
            int currstart=arr[i][0];
            int currend=arr[i][1];
            if(currstart<=end){
                end=Math.max(end,currend);
            }
            else{
                ans.add(new int[]{start,end});
                start=currstart;
                end=currend;

            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}