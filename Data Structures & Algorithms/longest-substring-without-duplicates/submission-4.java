class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use a map to keep track of characters seen and which index they were at
        // increase current count by 1 for each unique character
        // compare to the longest amount seen
        // once a non-unique character is seen, restart current count and clear map

        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int longestCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (seen.containsKey(currentChar) && seen.get(currentChar) >= left) { // prevent left pointer moving backwards
                left = seen.get(currentChar) + 1;
            }

            seen.put(currentChar, right);

            int currentCount = right - left + 1;

            System.out.println(s.substring(left, right + 1));

            longestCount = Math.max(longestCount, currentCount);
        }

        return longestCount;
    }
}
