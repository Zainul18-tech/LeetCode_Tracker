// Last updated: 09/07/2026, 10:37:21
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=-1;
            boolean f = false;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    f=true;
                }
                if(f&&nums2[j]>nums1[i]){
                    arr[i]=nums2[j];
                    break;
                }
            }
        }
        return arr;
    }
}