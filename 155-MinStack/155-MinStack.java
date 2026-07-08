// Last updated: 08/07/2026, 20:57:11
class MinStack {

    private Stack<Integer>A;
    private Stack<Integer>M;

    public MinStack() {
        A = new Stack<>();
        M = new Stack<>();
    }
    
    public void push(int value) {
        A.push(value);
        if (M.isEmpty()){
            M.push(value);
        }else{
            M.push(Math.min(value,M.peek()));
        }
    }
    
    public void pop() {
        A.pop();
        M.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int getMin() {
        return M.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */