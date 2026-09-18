class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder result=new StringBuilder();
        for(String word : arr){
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }
}