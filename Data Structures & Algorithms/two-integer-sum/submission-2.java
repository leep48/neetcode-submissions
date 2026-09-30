class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key = num, value = index
        // iterate through nums, add to hashmap as you go
        // check if target - current num exists in HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (map.containsKey(needed)) {
                return new int[] {map.get(needed), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
