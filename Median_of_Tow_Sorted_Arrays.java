#There are two sorted arrays nums1 and nums2 of size m and n respectively.

#Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] tmp = nums2;
            nums2=nums1;
            nums1=tmp;
        }
        int min = 0;
        int max = nums1.length;
        int i,j;
        while(min<=max){
            i=(min+max)/2;
            j=(nums1.length+nums2.length+1)/2-i;
            if((i==0||nums1[i-1]<=nums2[j])&&(i==nums1.length||nums1[i]>=nums2[j-1])){
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (nums1.length + nums2.length) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == nums1.length) { minRight = nums2[j]; }
                else if (j == nums2.length) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
            else if(i>0&&nums1[i-1]>nums2[j]){
                max=i-1;
            }
            else{
                min=i+1;
            }
        }
               
        return 0;
    }
}
