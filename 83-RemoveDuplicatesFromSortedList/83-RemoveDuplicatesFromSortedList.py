# Last updated: 08/07/2026, 20:57:28
class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
    def deleteDuplicates(self, head):

        if not head:
            return head
            
        seen = set()
        curr = head
        seen.add(curr.val)

        while curr.next:
            if curr.next.val in seen:
                curr.next = curr.next.next
            else:
                seen.add(curr.next.val)
                curr = curr.next 

        return head