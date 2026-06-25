class Solution {
    public int[] twoSum(int[] nums, int target) {
        // first, put every element into a hashmap: key -> num, value -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int findNum = target - nums[i];
            if (map.containsKey(findNum)) {
                int findIndex = map.get(findNum);
                return new int[] {findIndex, i};
            }
            map.put(nums[i], i);
        }

        // iterate through array
        // target - num = findNum
        // search for findNum in map

        return new int[0];
    }
}
