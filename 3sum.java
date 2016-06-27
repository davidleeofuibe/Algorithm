//how to deal with the duplicate
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null) return null;
        
        List<List<Integer>> rsts=new ArrayList<List<Integer>>();
        if(nums.length==0) return rsts;
        
        Arrays.sort(nums);
        
        
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int target=-nums[i];
            int end=nums.length-1;
            int start=i+1;
            while(start<end){
                if((nums[start]+nums[end])==target){
                    ArrayList<Integer> rst=new ArrayList<Integer>();
                    rst.add(nums[i]);
                    rst.add(nums[start]);
                    rst.add(nums[end]);
                    rsts.add(rst);
                    start++;
                    end--;
                    while(start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end+1]){
                        end--;
                    }
                }else if((nums[start]+nums[end])<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        
        return rsts;
    }
}