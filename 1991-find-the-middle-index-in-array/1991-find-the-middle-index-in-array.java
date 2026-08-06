class Solution {
    public int findMiddleIndex(int[] nums) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            total -= nums[i];      // Now total becomes rightSum

            if (leftSum == total) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}