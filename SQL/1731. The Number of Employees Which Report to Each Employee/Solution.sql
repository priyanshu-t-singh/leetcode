SELECT
    m.employee_id,
    m.name,
    COUNT(e.reports_to) AS reports_count,
    ROUND(AVG(e.age), 0) AS average_age
FROM Employees m
JOIN Employees e ON m.employee_id = e.reports_to
GROUP BY e.reports_to
ORDER BY m.employee_id;
