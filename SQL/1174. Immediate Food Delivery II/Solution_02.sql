WITH RankedOrder AS (
    SELECT
        delivery_id,
        customer_id,
        order_date,
        customer_pref_delivery_date,
        ROW_NUMBER() OVER(PARTITION BY customer_id ORDER BY order_date) as rn
    FROM Delivery
)
SELECT
    ROUND(
        SUM(IF(order_date = customer_pref_delivery_date, 1, 0)) / COUNT(*) * 100
    , 2) AS immediate_percentage
FROM RankedOrder
WHERE rn = 1;
