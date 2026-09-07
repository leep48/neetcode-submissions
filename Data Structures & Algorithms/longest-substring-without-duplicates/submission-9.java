class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> count = new HashMap<>();

        int l = 0;
        int best = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.merge(c, 1, Integer::sum);

            // remove duplicate step
            while (count.get(c) > 1) {
                char out = s.charAt(l);
                count.merge(out, -1, Integer::sum);
                l++;
            }

            best = Math.max(best, r - l + 1);
        }

        return best;
    }
}
