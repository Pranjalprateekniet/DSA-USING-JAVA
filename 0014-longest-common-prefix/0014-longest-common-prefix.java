class Solution {
    public String longestCommonPrefix(String[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int s1len=arr[0].length();
        String pre="";
        String s1=arr[0];
        String s2=arr[n-1];
        for(int i=0;i<s1len;i++){
            if(s1.charAt(i)==s2.charAt(i))
                pre+=s1.charAt(i);
            else
                return pre;
        }
        return pre;
    }
}