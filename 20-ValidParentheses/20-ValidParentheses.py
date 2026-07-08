# Last updated: 08/07/2026, 20:57:50
class Solution:
    def isValid(self, s: str) -> bool:
        
        stack =[]

        for ch in s:

            if ch in "({[":
                stack.append(ch)
            else:
                if not stack:
                    return False
                top = stack.pop()

                if ch==")" and top !="(":
                    return False       
                if ch=="}" and top !="{":
                    return False
                if ch=="]" and top !="[":
                    return False 

        return not stack       
        