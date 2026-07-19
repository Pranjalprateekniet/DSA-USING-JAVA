class Solution {
    private static boolean isvalid(String s,int left,int right){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void func(String s,int start,List<String>diary,List<List<String>>res){
        if(start==s.length()){
                res.add(new ArrayList<>(diary));
                return;
        }
        for (int i=start;i<s.length();i++){
            if(isvalid(s,start,i)){
                diary.add(s.substring(start,i+1));
                func(s,i+1,diary,res);
                diary.remove(diary.size()-1);
            }
        }

    }

    public List<List<String>> partition(String s) {
        //your code goes here
        List<String>diary=new ArrayList<>();
        List<List<String>>res=new ArrayList<>();
        func(s,0,diary,res);
        return res;

    }
}