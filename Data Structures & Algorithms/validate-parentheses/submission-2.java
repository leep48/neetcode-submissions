class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if (s.length()%2 != 0) {
            return false;
        }

        for (char sChar : s.toCharArray()) {
            if (sChar == '(' || sChar == '{' || sChar == '[') {
                stack.push(sChar);
            } else {
                if (stack.size() >= 1) {
                    if (sChar == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (sChar == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (sChar == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
