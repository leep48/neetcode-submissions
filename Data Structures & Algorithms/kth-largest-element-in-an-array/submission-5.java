class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        // quickselect, quicksort but only onto the partition containing the index k
        // partition picks a pivot, rearrange so left < pivot and right > pivot, returns pivot's final index
        // 0 1 2 3 4 --> (nums.length = 5) - (k = 3) --> index 2
        int index = nums.length - k;
        return quickselect(nums, index);
    }

    private int quickselect(int[] nums, int index) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int pivotIndex = partition(nums, start, end);
            if (pivotIndex == index) {
                break;
            } else if (index > pivotIndex) {
                start = pivotIndex + 1;
            } else {
                end = pivotIndex - 1;
            }
        }
        return nums[index];
    }

    private int partition(int[] nums, int start, int end) {
        int boundary = start;
        int right = start;
        int pivotIndex = rand.nextInt((end - start) + 1) + start;
        swap(nums, pivotIndex, end);
        while (right < end) {
            if (nums[right] < nums[end]) {
                swap(nums, right, boundary);
                boundary++;
            }
            right++;
        }
        swap(nums, boundary, end);
        return boundary;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
