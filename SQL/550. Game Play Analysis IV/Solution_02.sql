SELECT
    ROUND(
        COUNT(DISTINCT currAct.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity)
    , 2) AS fraction
FROM Activity currAct
JOIN Activity prevAct
    ON currAct.player_id = prevAct.player_id
    AND DATEDIFF(currAct.event_date, prevAct.event_date) = 1
WHERE
    (currAct.player_id, prevAct.event_date) IN (
        SELECT player_id, MIN(event_date)
        FROM Activity
        GROUP BY player_id
    )
;
