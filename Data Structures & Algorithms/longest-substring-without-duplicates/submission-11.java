class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window, hashset to track seen
        int l = 0;
        int longest = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
