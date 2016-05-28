import java.util.*;

public class Solution {
	public static int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length){
			System.out.println("here")
			if(nums1[i]==nums2[j]){
				System.out.print(Object obj)
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i]>nums2[j]){
				j++;
			}else{
				i++;
			}
		}
		int[] result=new int[list.size()];
		for(int k=0;k<list.size();k++){
			result[k]=list.get(k);
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] nums1={1};
		int[] nums2={1};
		intersect(nums1, nums2);
	}
}