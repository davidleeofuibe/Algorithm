/*
Key points: node that has been in stack and not have been in are different.
should use different name to denote, once a node been pop from a stack, it already been
find the leftmost child so that no need to do that again.

Key trick: maintain a lastvisited node as singal. if lastvisited is right child, means
this node has been visited twice.
*/
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        List<Integer> result=new ArrayList<Integer>();
        TreeNode lastvisited=null;
        while(!stack.empty() || node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                TreeNode topnode=stack.pop();
                if(topnode.right==null || topnode.right==lastvisited){
                    result.add(topnode.val);
                    lastvisited=topnode;
                }else{
                    node=topnode.right;
                    stack.push(topnode);
                }
            }
        }
        return result;
    }
}