-- Last updated: 09/07/2026, 10:38:03
SELECT name AS Customers
FROM customers a
LEFT JOIN orders b
ON a.id = b.customerId
WHERE b.customerId IS NULL;