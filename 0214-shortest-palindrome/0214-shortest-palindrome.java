class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev;

        int[] lps = new int[combined.length()];

        int len = 0;

        for (int i = 1; i < combined.length(); i++) {

            while (len > 0 && combined.charAt(i) != combined.charAt(len)) {
                len = lps[len - 1];
            }

            if (combined.charAt(i) == combined.charAt(len)) {
                len++;
            }

            lps[i] = len;
        }

        int longestPalindrome = lps[combined.length() - 1];

        String add = s.substring(longestPalindrome);

        return new StringBuilder(add).reverse().toString() + s;
    }
}