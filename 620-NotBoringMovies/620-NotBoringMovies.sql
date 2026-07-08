-- Last updated: 08/07/2026, 20:56:36
# Write your MySQL query statement below
SELECT *
FROM Cinema
WHERE id % 2 = 1
  AND description <> 'boring'
ORDER BY rating DESC;