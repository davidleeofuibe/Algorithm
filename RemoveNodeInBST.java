/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /*
     * The key point here is to find the parent of a node rather than the node.
     * After find the node, two cases: right child is null, then change the parent corresponding child to node left child. 
     * if not, then need to find left most node in the right subtree of node, use it to replace node and delete this node.
     * Pay special attention to the case where not find this value.(else{return dummy.left;})
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if(root==null){
            return null;
        }
        
        TreeNode dummy=new TreeNode(0);
        dummy.left=root;
        TreeNode parent=search(dummy,root,value);
        TreeNode node;
        
        if(parent.left!=null && parent.left.val==value){
            node=parent.left;
        }else if(parent.right!=null && parent.right.val==value){
            node=parent.right;
        }else{
            return dummy.left;
        }
        
        if(node.right==null){
            if(parent.left==node){
                parent.left=node.left;
            }else{
                parent.right=node.left;
            }
        }else{
            TreeNode father=node;
            TreeNode temp=node.right;
            while(temp.left!=null){
                father=temp;
                temp=temp.left;   
            }
            if(father.right==temp){
                father.right=temp.right;
            }else{
                father.left=temp.right;
            }
            
            if(parent.left==node){
                parent.left=temp;
            }else{
                parent.right=temp;
            }
            
            temp.left=node.left;
            temp.right=node.right;
        }
        
        return dummy.left;
        
        
    }
    
    private TreeNode search(TreeNode parent, TreeNode root, int value){
        if(root==null) return parent;
        if(root.val==value) return parent;
        if(root.val>value){
            parent=root;
            return search(root,root.left,value);
        }else{
            parent=root;
            return search(root,root.right,value);
        }
    }
    
}
