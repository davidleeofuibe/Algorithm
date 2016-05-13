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
 /**
  * Main idea of whole process is whenever find a node that is not
  * full node (both left and right are not null), following nodes
  * should be leaf node if this tree is complete
  */
public class isCompleteTree {
    LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    public boolean isComplete(TreeNode root) {
        if(root==null) return true;
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left!=null && node.right!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.right!=null){
                return false;
            }else{
                queue.offer(node.left);
                while(!queue.isEmpty()){
                    TreeNode followingNode=queue.poll();
                    if(followingNode.left!=null || followingNode.right!=null){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}