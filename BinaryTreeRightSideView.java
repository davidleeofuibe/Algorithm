/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//PSA need minvalue rather than just -1 for denoting the endnode.
//use null is best solution, see
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        
        TreeNode endNode=new TreeNode(Integer.MIN_VALUE);
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(endNode);
        
        TreeNode previous=null;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.val!=Integer.MIN_VALUE){
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }else{
                if(previous.val!=Integer.MIN_VALUE){
                    queue.offer(endNode);
                    result.add(previous.val);
                }
            }
            previous=node;
        }
        
        return result;
        
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        
        Stack<ArrayList<Integer>> stack=new Stack<ArrayList<Integer>>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }else{
                stack.push(list);
                if(!queue.isEmpty()){
                    list=new ArrayList<Integer>();
                    queue.offer(null);
                }  
            }
        }
        
        while(!stack.empty()){
            result.add(stack.pop());
        }
        return result;
    }
}