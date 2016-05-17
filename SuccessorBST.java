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
 * Track down the successor while find p's position
 * if it is go to left tree, the it's successor, else it's not the successor.
 * No need for any data structure.
 *
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p==null){
            return null;
        }
        if(p.right!=null){
            TreeNode node=p.right;
            while(node.left!=null){
                node=node.left;
            }
            return node;
        }else{
            TreeNode successor=null;
            TreeNode temp=root;
            while(temp.val!=p.val){
                if(temp.val>p.val){
                    successor=temp;
                    temp=temp.left;
                }else{
                    temp=temp.right;
                }
            }
            
            return successor;
        }
    }
}