/*
Tricks, find kth instead of finding the median directly, so that can gracefully handle the odd and even problem
When one array is less than k/2, then just mark it as Integer.MAX_VALUE, since even with all elements in this array.
it's not possible for element within k/2 area in another array to be the kth in two array.
*/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthsum=nums1.length+nums2.length;
        
        if(lengthsum % 2==1){
            return findKth(nums1,0,nums2,0,lengthsum/2+1);
        }else{
            return (findKth(nums1,0,nums2,0,lengthsum/2)+findKth(nums1,0,nums2,0,lengthsum/2+1))*0.5;
        }
    }
    
    private int findKth(int[] A, int A_start,int[] B,int B_start,int k){
        
        if(A_start>A.length-1){
            return B[B_start+k-1];
        }
        
        if(B_start>B.length-1){
            return A[A_start+k-1];
        }
        
        if(k==1){
            return Math.min(A[A_start],B[B_start]);
        }
        
        int A_position=A_start+k/2-1;
        int A_key=A_position>(A.length-1)?Integer.MAX_VALUE:A[A_position];
        
        int B_position=B_start+k/2-1;
        int B_key=B_position>(B.length-1)?Integer.MAX_VALUE:B[B_position];
        
        if(A_key>B_key){
            return findKth(A,A_start,B,B_start+k/2,k-k/2);
        }else{
            return findKth(A,A_start+k/2,B,B_start,k-k/2);
        }
    }
}