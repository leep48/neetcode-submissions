class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap for freq
        // iterate through hashmap entrysets for top k frequent elements

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] mostFreq = new int[k];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> maxEntry = null;
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
            mostFreq[i] = maxEntry.getKey();
            entries.remove(maxEntry);
        }

        return mostFreq;
    }
}
