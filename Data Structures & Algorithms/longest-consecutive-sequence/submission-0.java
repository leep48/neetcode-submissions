class Solution {
    public int longestConsecutive(int[] nums) {
        // hashset
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            int currLength = 1;
            if (!set.contains(num - 1)) {
                int i = 1;
                while (set.contains(num + i)) {
                    currLength++;
                    i++;
                }
            }
            if (currLength > longest) longest = currLength;
        }

        return longest;
    }
}
