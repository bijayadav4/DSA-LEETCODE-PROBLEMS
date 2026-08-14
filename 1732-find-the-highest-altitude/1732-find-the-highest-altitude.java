class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highest = 0;
        for(int  i = 0; i<gain.length; i++){
            currentAltitude = currentAltitude + gain[i];
            highest = Math.max(highest,currentAltitude);
        }
        return highest;
    }
}