class Solution {
    public String reverseWords(String s) {
        ArrayList<String>list=new ArrayList<>();
        int n=s.length();
        int start=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                String word=s.substring(start,i);
                if(start<i){
                list.add(word);
                }
                start=i+1;
            }
            }
            if (start < n) {
            list.add(s.substring(start, n));
            }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size();i++) {
             sb.append(list.get(i));
             if (i != list.size() - 1) {
                 sb.append(" ");
    }
}
return sb.toString();
        }
    }