/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class Solution {
    public int trap(int[] height) {
        if(height.length<1)
            return 0;
        int maxLeft=height[0],maxRight=height[height.length-1],left=0,right=height.length-1,sum=0;
        while(left<=right){
            if(maxLeft<=maxRight){
                if(height[left]<=maxLeft){
                    sum +=maxLeft-height[left];
                }
                else{
                    maxLeft = height[left];
                }
                    left++;                
            }
            else{
                if(height[right]<=maxRight){
                    sum +=maxRight-height[right];
                }
                else{
                    maxRight = height[right];
                }
                    right--;                
            }
        }
        return sum;
    }
}
