/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head,null);
    }
    
    private TreeNode helper(ListNode head,ListNode tail){
        if(head==null || head==tail) return null;
        
        ListNode middleLN=findMiddle(head,tail);
        TreeNode middleTN=new TreeNode(middleLN.val);
        TreeNode left=helper(head,middleLN);
        TreeNode right=helper(middleLN.next,tail);
        
        middleTN.left=left;
        middleTN.right=right;
        
        return middleTN;
        
    }
    
    private ListNode findMiddle(ListNode head,ListNode tail){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=tail && fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}