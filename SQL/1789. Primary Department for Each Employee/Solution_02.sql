SELECT
    employee_id,
    department_id
FROM Employee e1
WHERE
    1 = (
        SELECT COUNT(*) FROM Employee e2
        WHERE e1.employee_id = e2.employee_id
    )
    OR primary_flag = 'Y'
;
