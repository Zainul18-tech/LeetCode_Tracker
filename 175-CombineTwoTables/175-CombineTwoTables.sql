-- Last updated: 08/07/2026, 20:57:02
# Write your MySQL query statement below
SELECT
    p.FirstName,
    p.LastName,
    a.City,
    a.State
FROM Person p
LEFT JOIN Address a
ON p.PersonId = a.PersonId;