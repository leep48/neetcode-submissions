class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use freq array converted to string as key
        // value is list of anagrams
        HashMap<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
