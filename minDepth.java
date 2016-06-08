//PSA if a one child of a node is null, we cannot compare it directly with the another child node
//since it will always considering the null node which will give us wrong result
//consider the case [1,2]
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        if(root.left==null){
            return minDepth(root.right)+1;
        }
        
        if(root.right==null){
            return minDepth(root.left)+1;
        }
        
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }
}