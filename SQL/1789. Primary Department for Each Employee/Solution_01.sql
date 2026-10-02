SELECT employee_id, department_id
FROM Employee e1
WHERE primary_flag = 'Y'

UNION ALL

SELECT employee_id, department_id
FROM Employee e2
GROUP BY employee_id
HAVING COUNT(*) = 1;
