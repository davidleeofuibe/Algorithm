public class Solution {
    public int maxArea(int[] height) {
        if(height==null) return 0;
        if(height.length==1) return 0;
        int left=0;
        int right=height.length-1;
        int max=Math.min(height[left],height[right])*(right-left);
        
        while(left<right){
            if(height[left]<=height[right]){
                int i=left+1;
                while(i<right && height[left]>=height[i]){
                    i++;
                }
                left=i;
            }else{
                int j=right-1;
                while(j>left && height[right]>=height[j]){
                    j--;
                }
                right=j;
            }
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
        }
        
        return max;
    }
}