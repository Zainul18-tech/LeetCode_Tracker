# Last updated: 12/07/2026, 14:47:40
1class Solution:
2    def multiply(self, num1: str, num2: str) -> str:
3        if num1 == "0" or num2 == "0":
4            return "0"
5
6        m, n = len(num1), len(num2)
7        result = [0] * (m + n)
8
9        for i in range(m - 1, -1, -1):
10            for j in range(n - 1, -1, -1):
11                mul = int(num1[i]) * int(num2[j])
12                total = mul + result[i + j + 1]
13
14                result[i + j + 1] = total % 10
15                result[i + j] += total // 10
16
17        ans = []
18        for num in result:
19            if not (len(ans) == 0 and num == 0):
20                ans.append(str(num))
21
22        return "".join(ans)