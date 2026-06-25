class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hash map <sorted character string, arraylist of anagrams>
        // iterate through array of strings, sorted character string -> key, original strings array -> value

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            //System.out.println(sortedString);

            //map.put(sortedString, map.getOrDefault(sortedString, new ArrayList<String>(0)).add(s));

            
            if (map.containsKey(sortedString)) {
                ArrayList<String> strList = map.get(sortedString);
                strList.add(s);
                map.put(sortedString, strList);
            } else {
                map.put(sortedString, new ArrayList<String>(Arrays.asList(s)));
            }
            
        }

        return new ArrayList<>(map.values());
    }
}
