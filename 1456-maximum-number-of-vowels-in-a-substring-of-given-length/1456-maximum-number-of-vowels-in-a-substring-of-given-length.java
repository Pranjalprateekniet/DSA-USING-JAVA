class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int count=0;
        
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        int max=count;
        int left=0;
        for(int i=k;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
            char chl=s.charAt(left);
            if(chl=='a'||chl=='e'||chl=='i'||chl=='o'||chl=='u'){
                count--;
            }
            left++;
            max=Math.max(max,count);
        }
        return max;

    }
}