/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
               helper(nums,nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
    public void helper(int[] nums, int n){
        int tmp;
        int len = nums.length;
        if(n<1||n>len||nums[n-1]==n)
            return;
        tmp = nums[n-1];
        nums[n-1]=n;
        helper(nums,tmp);
   }
}
