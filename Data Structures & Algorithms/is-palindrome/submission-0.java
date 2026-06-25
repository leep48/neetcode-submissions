class Solution {
    public boolean isPalindrome(String s) {
        String sClean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (sClean.length() <= 1) {
            return true;
        }

        for (int i = 0; i < (int) (sClean.length()/2); i++) {
            if (sClean.charAt(i) != sClean.charAt(sClean.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
