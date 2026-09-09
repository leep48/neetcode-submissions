class Solution {
    public int characterReplacement(String s, int k) {
        // find most frequent char -> window - freq char = replacements needed
        int l = 0;
        int[] freq = new int[26];
        int highestFreq = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;

            // find most freq
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > highestFreq) {
                    highestFreq = freq[i];
                }
            }

            // when replacements needed > k, shift left pointer
            while (((r - l + 1) - highestFreq) > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
                for (int i = 0; i < freq.length; i++) {
                    if (freq[i] > highestFreq) {
                        highestFreq = freq[i];
                    }
                }
            }

            longest = (r - l + 1) > longest ? (r - l + 1) : longest;
        }

        return longest;
    }
}
