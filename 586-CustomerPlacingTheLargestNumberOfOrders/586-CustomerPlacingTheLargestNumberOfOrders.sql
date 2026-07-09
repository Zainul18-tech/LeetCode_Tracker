-- Last updated: 09/07/2026, 10:37:13
# Write your MySQL query statement below

select customer_number
from orders
group by customer_number
order by count(*) DESC limit 1;