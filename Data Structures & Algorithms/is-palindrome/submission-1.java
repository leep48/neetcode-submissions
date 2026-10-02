class Solution {
    public boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^a-zA-Z0-9]", "");
        clean = clean.toLowerCase();
        // two pointers moving inward
        int length = clean.length();

        if (length == 0) return true;

        int right = length - 1;
        for (int left = 0; left < length/2; left++) {
            if (clean.charAt(left) != clean.charAt(right)) return false;
            right--;
        }

        return true;
    }
}
