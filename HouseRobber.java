/*
Typical dynamic programming
*/
public class Solution {
    //House Robber I
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int[][] f=new int[nums.length][2];
        
        f[0][0]=0;
        f[0][1]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            f[i][0]=Math.max(f[i-1][0],f[i-1][1]);
            f[i][1]=f[i-1][0]+nums[i];        
        }
        
        return Math.max(f[nums.length-1][0],f[nums.length-1][1]);
    }
    //House Robber 2, first one connect to last one
    //use the third dimension to denote if the first room is stolen
    //Pay special attention that if number length<=1, cannot do the loop part
    public int rob(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        
        if(nums.length==1){
            return nums[0];
        }
        
        int[][][] f=new int[nums.length][2][2];
        f[1][0][0]=0;
        f[1][0][1]=nums[0];
        f[1][1][0]=nums[1];
        f[1][1][1]=-1;
        
        for(int i=2;i<nums.length;i++){
            f[i][0][0]=Math.max(f[i-1][0][0],f[i-1][1][0]);
            f[i][1][0]=nums[i]+f[i-1][0][0];
            f[i][0][1]=Math.max(f[i-1][0][1],f[i-1][1][1]);
            f[i][1][1]=nums[i]+f[i-1][0][1];
        }
        
        int last=nums.length-1;
        return Math.max(f[last][1][0],Math.max(f[last][0][1],f[last][0][0]));
    }

    
    //House Rob 3
    //use recursive
    public int rob(TreeNode root) {
        int[] result=helper(root);
        return Math.max(result[0],result[1]);
    }
    
    private int[] helper(TreeNode root){
        int[] result=new int[2];
        if(root==null){
            result[0]=0;
            result[1]=0;
            return result;
        }
        int[] leftresult=helper(root.left);
        int[] rightresult=helper(root.right);
        
        int result1=leftresult[1]+rightresult[1];
        int result2=leftresult[0]+rightresult[1];
        int result3=leftresult[1]+rightresult[0];
        int result4=leftresult[0]+rightresult[0];
        
        result[0]=Math.max(Math.max(result1,result2),Math.max(result3,result4));
        result[1]=result4+root.val;
        
        return result;
    }
}