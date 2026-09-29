SELECT m.name
FROM Employee m
JOIN Employee e ON e.managerId = m.id
GROUP BY m.id
HAVING COUNT(e.id) >= 5;
