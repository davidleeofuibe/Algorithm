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
public class InsertationOnBST {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if(root==null) return node;
        if(root.val>node.val){
           root.left=insertNode(root.left,node);
        }else if(root.val<node.val){
            root.right=insertNode(root.right,node);
        }
        return root;
    }
}