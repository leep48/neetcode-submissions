class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            int highestFreq = 0;
            freq[s.charAt(r) - 'A']++;

            // window size - most freq char = replacements needed
            // shift l if over replacements needed > k
            for (int f : freq) {
                if (f > highestFreq) {
                    highestFreq = f;
                }
            }

            int rep = (r - l + 1) - highestFreq;

            if (rep > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
                // System.out.println("Next left, longest = " + longest + ", r = " + r);
            } else {
                longest = Math.max(longest, r - l + 1);
                // System.out.println("New longest at window: " + l + ", " + r + " - highest freq = " + highestFreq);
            }
        }

        return longest;
    }
}
