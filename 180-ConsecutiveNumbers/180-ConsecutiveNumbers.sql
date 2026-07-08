-- Last updated: 08/07/2026, 20:56:59
# Write your MySQL query statement below
SELECT DISTINCT Num AS ConsecutiveNums
FROM (
    SELECT
        Num,
        LAG(Num, 1) OVER (ORDER BY Id) AS Prev1,
        LAG(Num, 2) OVER (ORDER BY Id) AS Prev2
    FROM Logs
) t
WHERE Num = Prev1
AND Num = Prev2;