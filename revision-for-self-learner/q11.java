    import java.util.*;
    public class q11 {

       static class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int val1){
                this.val=val1;
            }

        }

        private static TreeNode buildtree(int arr[]){
            if(arr.length==0 || arr[0]==-1)
                return null;
            TreeNode root=new TreeNode(arr[0]);
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            int i=1;
            while(i<arr.length){
                TreeNode curr=q.poll();
                if(i<arr.length && arr[i]!=-1){
                    curr.left= new TreeNode(arr[i]);
                    q.add(curr.left);
                }
                i++;
                if(i<arr.length && arr[i]!=-1){
                    curr.right=new TreeNode(arr[i]);
                    q.add(curr.right);
                }
                i++;
            }
            return root;
        }



        private static List<List<Integer>>zigzagtraversal(TreeNode root){
            List<List<Integer>>ans=new ArrayList<>();
            if(root==null)
                return ans;
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root);
            int c=0;
            while(!q.isEmpty()){
                int size=q.size();
                
                List<Integer> list=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    list.add(node.val);
                    if(node.left!=null){
                        q.add(node.left);

                    }
                    if(node.right!=null)
                        q.add(node.right);

                }
                if(c%2==0)
                    ans.add(list);
                else
                    {
                        Collections.reverse(list);
                        ans.add(list);
                    }
                    c++;
            }
            return ans;
        }
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            TreeNode root=buildtree(arr);
            List<List<Integer>>ans=new ArrayList<>();
            ans=zigzagtraversal(root);
            for(int i=0;i<ans.size();i++){
                System.out.println(ans.get(i));
            }
        }
    }
