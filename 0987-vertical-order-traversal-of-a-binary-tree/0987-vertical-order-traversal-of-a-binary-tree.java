/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class tuple{
        TreeNode node;
        int row;
        int col;
        public tuple(TreeNode node1,int row1,int col1){
            node=node1;
            row=row1;
            col=col1;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<tuple>q=new LinkedList<tuple>();
        q.add(new tuple(root,0,0));
        while(!q.isEmpty()){
            tuple tup=q.poll();
            TreeNode node=tup.node;
            int x=tup.row;
            int y=tup.col;
            if(!map.containsKey(x))
                map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y))
                map.get(x).put(y,new PriorityQueue<>());
            map.get(x).get(y).add(node.val);
            if(node.left!=null)
                q.add(new tuple(node.left,x-1,y+1));
            if(node.right!=null)
                q.add(new tuple(node.right,x+1,y+1));

        }
        List<List<Integer>>list=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>>yn: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer>nodes : yn.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}