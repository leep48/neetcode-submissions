class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length/2;

        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right + left)/2;
        }
        return -1;
    }
}
