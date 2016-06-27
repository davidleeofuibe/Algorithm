public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null) return 0;
        int len=nums.length;
        int end=0;
        
       for(int i=1; i<len; i++) {
            if(nums[i]!=nums[end]) {
                end++;
                if(i!=end) nums[end] = nums[i];
            }
        }
        return end+1;
    }
}