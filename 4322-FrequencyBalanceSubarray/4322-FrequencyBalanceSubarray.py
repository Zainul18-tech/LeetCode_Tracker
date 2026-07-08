# Last updated: 08/07/2026, 20:56:03
from collections import defaultdict
from typing import List

class Solution:
    def getLength(self, nums: List[int]) -> int:
        dremovical = nums
        
        n = len(nums)
        ans = 1

        for i in range(n):
            freq = defaultdict(int)
            countFreq = defaultdict(int)
            mx = 0
            
            for j in range(i, n):
                x = nums[j]

                old = freq[x]

                if old:
                    countFreq[old] -= 1
                    if countFreq[old] == 0:
                        del countFreq[old]
                        
                freq[x] += 1        
                new = freq[x]

                countFreq[new] += 1
                mx = max(mx,new)

                length = j-i+1

                if len(freq) == 1:
                    ans = max(ans,length)
                    continue

                if mx%2:
                    continue

                half = mx // 2

                if set(countFreq.keys()) != {mx,half}:
                    continue

                if countFreq[mx] == 0:
                    continue
                if countFreq[half] == 0:
                    continue

                ans = max(ans,length)
                
        return ans        