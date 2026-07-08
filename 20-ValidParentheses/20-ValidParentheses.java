// Last updated: 08/07/2026, 20:57:45
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if(ch =='(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(ch==')' && top!= '('){
                    return false;
                }
                if(ch ==']' && top!= '['){
                    return false;
                }
                if (ch == '}' && top!= '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}