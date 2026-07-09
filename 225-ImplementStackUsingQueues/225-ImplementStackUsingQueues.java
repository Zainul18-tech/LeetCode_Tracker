// Last updated: 09/07/2026, 10:37:48
class MyStack {
    Queue<Integer> a ;
    public MyStack() {
        this.a = new ArrayDeque<>();
    }
    
    public void push(int x) {
        a.add(x);
        for(int i=0;i<a.size()-1;i++){
            a.add(a.poll());
        }
    }
    
    public int pop() {
        return a.poll();
    }
    
    public int top() {
        return a.peek();
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */