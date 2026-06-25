class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use a map to keep track of characters seen and which index they were at
        // increase current count by 1 for each unique character
        // compare to the longest amount seen
        // once a non-unique character is seen, restart current count and clear set

        Map<Character, Integer> seen = new HashMap<>();
        int currentCount = 0;
        int longestCount = 0;

        if (s.length() <= 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (seen.containsKey(currentChar)) {
                currentCount = 0;
                i = seen.get(currentChar);
                seen.clear();
            } else {
                seen.put(currentChar, i);
                currentCount++;
            }
            if (currentCount > longestCount) {
                longestCount = currentCount;
            }
        }

        return longestCount;
    }
}
