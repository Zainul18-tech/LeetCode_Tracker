-- Last updated: 09/07/2026, 10:37:14
# Write your MySQL query statement below
SELECT e.name, b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empID = b.empID
WHERE b.bonus IS NULL OR b.bonus < 1000; 