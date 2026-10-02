class Solution {
    public int maxArea(int[] heights) {
        // two pointer, shift pointer that is smaller
        int l = 0;
        int r = heights.length - 1;
        int max = 0;

        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int length = r - l;
            max = Math.max(max, length * height);

            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
