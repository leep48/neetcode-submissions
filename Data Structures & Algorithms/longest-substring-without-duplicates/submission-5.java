class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use hashmap to keep track of seen characters and their index
        HashMap<Character, Integer> map = new HashMap<>();

        int longest = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // if see duplicate within our valid window
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                left = map.get(s.charAt(right)) + 1;
            }

            map.put(s.charAt(right), right);
            
            int count = right - left + 1;

            if (count > longest) {
                longest = count;
            }
        }

        return longest;

    }
}
