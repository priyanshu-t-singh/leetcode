SELECT MAX(num) as num
FROM (
    SELECT num as num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
) AS SingleNumbers;
