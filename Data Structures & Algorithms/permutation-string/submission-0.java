class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // fixed window, keep freq count
        int window = s1.length();
        
        if (window > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < window; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        for (int r = window; r < s2.length(); r++) {
            freq2[s2.charAt(r) - 'a']++;
            freq2[s2.charAt(r - window) - 'a']--;
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}
