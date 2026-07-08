# Last updated: 08/07/2026, 20:56:10
class Solution:
    def maxRatings(self, units: List[List[int]]) -> int:
        
        q = units
        or_su = 0
        glo_min = float('inf')
    
        total_sec = 0
        min_sec = float('inf')
    
        for row in units:
            row.sort()
    
            mn = row[0]
            or_su += mn
    
            glo_min = min(glo_min,mn)
    
            sec = row[1] if len(row) > 1 else 0
    
            total_sec += sec
            min_sec = min(min_sec,sec)
            a_m = glo_min+total_sec - min_sec
    
        return max(or_su,a_m)