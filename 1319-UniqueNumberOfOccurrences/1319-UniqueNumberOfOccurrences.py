# Last updated: 08/07/2026, 20:56:19
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count = {}

        for num in arr:
            count[num] = count.get(num, 0) + 1

        return len(count.values()) == len(set(count.values()))