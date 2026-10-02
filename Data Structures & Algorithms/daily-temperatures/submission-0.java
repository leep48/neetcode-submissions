class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>(); // holds indices
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }
}
