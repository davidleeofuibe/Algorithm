/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Key here is pay attention to null value;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null){
                sb.append("null,");   
            }else{
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] array=data.split(",");
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode root=new TreeNode(Integer.parseInt(array[0]));
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(array[i].equals("null")){
                node.left=null;
            }else{
                TreeNode leftnode=new TreeNode(Integer.parseInt(array[i]));
                node.left=leftnode;
                queue.offer(leftnode);
            }
            i++;
            if(array[i].equals("null")){
                node.right=null;
            }else{
                TreeNode rightnode=new TreeNode(Integer.parseInt(array[i]));
                node.right=rightnode;
                queue.offer(rightnode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));