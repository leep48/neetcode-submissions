class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        if (s.length()%2 != 0) {
            return false;
        }

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                char peek = stack.peek();
                if (c == ')' && peek == '(') {
                    stack.pop();
                } else if (c == '}' && peek == '{') {
                    stack.pop();
                } else if (c == ']' && peek == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
