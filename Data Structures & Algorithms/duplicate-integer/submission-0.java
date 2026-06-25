class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        if (nums.length == 0) {
            return false;
        }

        for (int num : nums) {
            // If num exists in set -> means there is duplicate
            // If doesn't exist, insert into set -> means there is no duplicate yet
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}