//special case [1 null 2], it's the reason we need node!=null in while loop.
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        result.add(root.val);
        TreeNode node=root.left;
        while((!stack.empty()) || node!=null){
            while(node!=null){
                result.add(node.val);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop().right;
        }
        
        return result;
    }
}