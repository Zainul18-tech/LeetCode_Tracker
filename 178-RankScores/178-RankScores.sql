-- Last updated: 08/07/2026, 20:57:01
# Write your MySQL query statement below
SELECT
    Score,
    DENSE_RANK() OVER (ORDER BY Score DESC) AS 'Rank'
FROM Scores;