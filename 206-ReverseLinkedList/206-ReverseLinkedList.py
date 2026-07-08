# Last updated: 08/07/2026, 20:56:52
class ListNode:
     def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reverseList(self, head):

        prev = None  
        curr = head  

        while curr:
            
            temp = curr.next  
            curr.next = prev  
            prev = curr      
            curr = temp      

        return prev  


