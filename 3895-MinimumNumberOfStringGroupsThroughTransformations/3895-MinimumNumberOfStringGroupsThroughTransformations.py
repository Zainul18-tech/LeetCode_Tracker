# Last updated: 12/08/2026, 11:32:43
class Solution:
    def minimumGroups(self, words: List[str]) -> int:
        
        def smallest_rotation(s):
            n = len(s)
            if n <= 1:
                return s

            ss = s + s
            i,j,k = 0,1,0

            while i < n and j < n and k < n:
                if ss[i + k] == ss[j + k]:
                    k += 1
                elif ss[i + k] > ss[j + k]:
                    i = i + k + 1
                    if i <= j:
                        i = j + 1
                    k = 0
                else:
                    j = j + k + 1
                    if j <= i:
                        j = i + 1
                    k = 0

            start = min(i,j)
            return ss[start:start + n]

        groups = set()

        for word in words:
            even = word[::2]
            odd = word[1::2]
            
            key = (
                smallest_rotation(even),
                smallest_rotation(odd)
            )

            groups.add(key)
        return len(groups)