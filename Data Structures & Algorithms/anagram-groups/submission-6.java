class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sort chars of each string, this is the key
        // value is an array of strings
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        };

        return new ArrayList<>(map.values());
    }
}
