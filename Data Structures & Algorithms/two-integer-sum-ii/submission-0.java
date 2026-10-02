class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length - 1;

        for (int l = 0; l < numbers.length; l++) {
            int curSum = numbers[l] + numbers[r];
            while (curSum > target) {
                r--;
                curSum = numbers[l] + numbers[r];
            }
            if (curSum == target) return new int[] {l + 1, r + 1};
        }

        return null;
    }
}
