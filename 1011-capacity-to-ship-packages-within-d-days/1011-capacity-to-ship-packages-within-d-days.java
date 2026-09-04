class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int w : weights){
            left = Math.max(left,w);
            right += w;
        }
        while(left < right){
            int mid = left + (right - left)/2;
            int dayneed =1;
            int currentW = 0;
            for(int w : weights){
                if(currentW + w > mid){
                    dayneed++;
                    currentW = w;
                } else {
                    currentW += w;
                }
            }
            if(dayneed <= days){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}