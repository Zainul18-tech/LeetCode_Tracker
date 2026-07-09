// Last updated: 09/07/2026, 10:36:31
class Solution {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
   
     for(int i=1;i<nums.length;i++){
           for(int j=0;j<nums[i-1];j++){
            list.add(nums[i]);
           }
        i++;
     }
     int[] arr=new int[list.size()];
     for(int i=0;i<arr.length;i++){
        arr[i]=list.get(i);
     }
     return arr;
    }
}