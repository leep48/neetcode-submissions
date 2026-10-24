class MinStack {
    Stack<Integer> main;
    Stack<Integer> minStack;
    int currMin;

    public MinStack() {
        main = new Stack<>();
        minStack = new Stack<>();
        currMin = Integer.MAX_VALUE;        
    }
    
    public void push(int val) {
        if (val <= currMin) {
            minStack.push(currMin);
            currMin = val;
        }
        main.push(val);
    }
    
    public void pop() {
        int val = main.pop();
        if (val == currMin) {
            currMin = minStack.pop();
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return currMin;
    }
}
