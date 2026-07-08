# Last updated: 08/07/2026, 20:57:42
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        slow = head
        fast = head

        for i in range(n):
            if fast:
                fast = fast.next
        if not fast: return head.next

        while fast.next:
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next

        return head
