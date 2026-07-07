class Solution {
    public int pivotIndex(int[] nums) {
       int total = 0;
       for(int num : nums){
        total += num;
       } 
       int Leftsum = 0 ;
       for(int i =0 ; i<nums.length;i++){
        int Rightsum  = total - Leftsum - nums[i];
        if(Leftsum == Rightsum){
            return i;
        }
        Leftsum += nums[i];
       }
       return -1;
    }
}