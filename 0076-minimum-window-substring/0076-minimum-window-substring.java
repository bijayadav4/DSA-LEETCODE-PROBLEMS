class Solution {
    public String minWindow(String s, String t) {

        int[] count = new int[128];
        int[] window = new int[128];

        int required = 0;
        for (char c : t.toCharArray()) {
            if (count[c] == 0) {
                required++;
            }
            count[c]++;
        }

        int formed = 0;
        int left = 0;

        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;
            if (count[c] > 0 && window[c] == count[c]) {
                formed++;
            }
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (count[leftChar] > 0 &&
                    window[leftChar] < count[leftChar]) {
                    formed--;
                }

                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}