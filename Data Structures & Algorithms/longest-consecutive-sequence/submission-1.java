class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            int count = 1;
            if (!set.contains(num - 1)) {
                int i = 1;
                while (set.contains(num + i)) {
                    count++;
                    i++;
                }
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
}
