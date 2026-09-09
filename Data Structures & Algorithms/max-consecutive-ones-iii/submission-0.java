class Solution {
    public int longestOnes(int[] nums, int k) {
        // window size - ones seen in a window = flips needed
        // window should grow, not shrink
        int freq = 0;
        int l = 0;
        int max = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 1) freq++;

            int flips = (r - l + 1) - freq;

            if (flips > k) {
                if (nums[l] == 1) freq--;
                l++;
            } else {
                max = Math.max((r - l + 1), max);
            }
        }

        return max;
    }
}