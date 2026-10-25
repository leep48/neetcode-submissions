class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hash map, key identifies anagrams, value is list of grouped anagrams
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
