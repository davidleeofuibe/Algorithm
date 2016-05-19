/*
*Actually the number doesn't matter, what matter is they are monotone increase.
*Each level choose a number as the root, left part is left tree, right part is right tree
*Count[i] array denotes i consecutive number can genenrate how much unique BST 
*/


public class Solution {
    public int numTrees(int n) {
        int[] count=new int[n+1];
        count[0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                count[i]+=count[j-1]*count[i-j];
            }
        }
        
        return count[n];
    }
}