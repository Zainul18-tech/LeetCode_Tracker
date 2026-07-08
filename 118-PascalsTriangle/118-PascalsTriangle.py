# Last updated: 08/07/2026, 20:57:20
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        final=[[1]]
        for i in range(numRows-1):
            temp=[0]+final[-1]+[0]
            res=[]
            for j in range(len(temp)-1):
                res.append(temp[j]+temp[j+1])
            final.append(res)
        
        return final