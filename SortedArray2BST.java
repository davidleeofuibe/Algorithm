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
    /**
     * Pay special attention to the case that there are duplicate elements in array.
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if(A==null || A.length==0){
            return null;
        }
        int len=A.length;
        TreeNode root=new TreeNode(A[len/2]);
        buildBST(root,A,0,len/2-1);
        buildBST(root,A,len/2+1,len-1);
        return root;
    }  
    
    private void buildBST(TreeNode root,int[] A, int start, int end){
        if(start>end){
            return;
        }
        int mid=start+(end-start)/2;
        TreeNode middle=new TreeNode(A[mid]);
        if(A[mid]>root.val){
            root.right=middle;
        }else if(A[mid]<root.val){
			root.left=middle;
		}else{
			if(root.left==null){
				root.left=middle;
			}else{
				root.right=middle;
			}
		}

        
        buildBST(middle,A,start,mid-1);
        buildBST(middle,A,mid+1,end);
    }
}
