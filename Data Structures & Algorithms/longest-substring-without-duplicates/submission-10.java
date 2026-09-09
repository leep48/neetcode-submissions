class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if found duplicate char, shift left pointer until duplicate removed
        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            // if freq of char at r = 0, add to freq, check longest
            // else shift left pointer until freq of char r = 1

            freq.merge(s.charAt(r), 1, Integer::sum);

            while (freq.get(s.charAt(r)) > 1) {
                freq.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
