class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use freq array converted to string as key
        // value is list of anagrams
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);

            ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
