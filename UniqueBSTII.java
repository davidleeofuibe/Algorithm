/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 * Special attention to that arraylist can add null element
 * use this characteristic to make code concise.
 * Special case is n<1, PA
 *
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        if(n<1) return list;
        return genTrees(1,n);
    }
    
    private List<TreeNode> genTrees(int start, int end){
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftnodelist=genTrees(start,i-1);
            List<TreeNode> rightnodelist=genTrees(i+1,end);
            
                for(TreeNode left:leftnodelist){
                    for(TreeNode right:rightnodelist){
                        TreeNode root=new TreeNode(i);
                        root.left=left;
                        root.right=right;
                        list.add(root);
                    }
                }
        }
        return list;
    }
}