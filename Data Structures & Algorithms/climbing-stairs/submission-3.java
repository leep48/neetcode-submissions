class Solution {
    public int climbStairs(int n) {
        int curr = 0;
        int last = 1;
        int last2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            curr = last + last2;
            last2 = last;
            last = curr;
        }
        
        return curr;
    }
}
