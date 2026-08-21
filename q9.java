    import java.util.*;

    public class q9 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            List<String>res=new ArrayList<>();
            res=generateparanthesis(n);
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+",");
            }
        }
        private static List<String> generateparanthesis(int n){
            List<String>res=new ArrayList<>();
            StringBuilder sb=new StringBuilder();
            helper(0, 0, n, res, sb);
            return res;
        }
        private static void helper(int open,int close,int n,List<String>res,StringBuilder sb){
            if(open==n && close==n){
                res.add(sb.toString());
                return;

            }
            if(open<n)
            {
                sb.append("(");
                helper(open+1,close,n,res,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            if(close<open)
            {
                sb.append(")");
                helper(open, close+1, n, res, sb);
                sb.deleteCharAt(sb.length()-1);
            }


        }
    }
