class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use hash map to group anagrams together
        // key = array representing 26 lowercase english letters
        // value = array of strings (anagrams)

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cArr = str.toCharArray();
            int[] numChars = new int[26];

            for (char c : cArr) {
                numChars[c - 'a']++;
            }

            String key = Arrays.toString(numChars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
