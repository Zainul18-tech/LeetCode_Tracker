# Last updated: 12/08/2026, 11:32:07
class Solution:
    def countTasks(self, tasks: List[int], shifts: List[int]) -> List[int]:
        n = len(tasks)
        prefix = []

        s = 0
        for x in tasks:
            s += x
            prefix.append(s)

        total = s
        progress = 0
        ans = []

        for t in shifts:
            if progress + t >= total:
                ans.append(0)
                progress = 0
            else:
                progress += t
                completed = bisect_right(prefix, progress)
                ans.append(n - completed)

        return ans
        