// Last updated: 11/07/2026, 09:35:29
1import java.util.*;
2
3class Solution {
4    public boolean isValid(String s) {
5        Stack<Character> stack = new Stack<>();
6
7        for (char ch : s.toCharArray()) {
8            if (ch == '(' || ch == '{' || ch == '[') {
9                stack.push(ch);
10            } else {
11                if (stack.isEmpty()) {
12                    return false;
13                }
14
15                char top = stack.pop();
16
17                if ((ch == ')' && top != '(') ||
18                    (ch == '}' && top != '{') ||
19                    (ch == ']' && top != '[')) {
20                    return false;
21                }
22            }
23        }
24
25        return stack.isEmpty();
26    }
27}