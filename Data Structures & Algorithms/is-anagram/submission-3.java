class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 0 && t.length() == 0) {
            return true;
        }

        for (char sChar : sArr) {
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
        }

        for (char tChar : tArr) {
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        return sMap.equals(tMap);

    }
}
