# Last updated: 12/08/2026, 11:31:07
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countDominantNodes(self, root: TreeNode | None) -> int:
        count = 0

        def helper(node):
            nonlocal count

            if node is None:
                return float("-inf")

            left = helper(node.left)
            right = helper(node.right)

            max_value = max(node.val, left, right)

            if node.val == max_value:
                count +=1

            return max_value

        helper(root)
        return count