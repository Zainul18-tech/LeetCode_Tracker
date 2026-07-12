# Last updated: 12/07/2026, 14:42:10
1class Solution:
2    def judgeCircle(self, moves: str) -> bool:
3        x = y = 0
4
5        for move in moves:
6            if move == 'U':
7                y += 1
8            elif move == 'D':
9                y -= 1
10            elif move == 'L':
11                x -= 1
12            else:
13                x += 1
14
15        return x == 0 and y == 0