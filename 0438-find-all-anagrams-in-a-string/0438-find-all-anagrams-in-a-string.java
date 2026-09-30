import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            windowCount[c - 'a']++;
            if (i >= p.length()) {
                char left = s.charAt(i - p.length());
                windowCount[left - 'a']--;
            }
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}