public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2){
        if(start1>end1 || start2>end2){
            return null;
        }
        
        int rootval=preorder[start1];
        int rootindex=start2;
        for(int i=start2;i<=end2;i++){
            if(inorder[i]==rootval){
                rootindex=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootval);
        
        int leftlength=rootindex-start2;
        int rightlength=end2-rootindex;
        TreeNode left=helper(preorder,start1+1,start1+leftlength,inorder,start2,rootindex-1);
        TreeNode right=helper(preorder,start1+leftlength+1,end1,inorder,rootindex+1,end2);
        
        root.left=left;
        root.right=right;
        
        return root;
    }
}