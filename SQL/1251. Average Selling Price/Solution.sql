SELECT
    p.product_id,
    COALESCE(ROUND(SUM(p.price * us.units) / SUM(us.units), 2), 0) as average_price
FROM UnitsSold us
RIGHT JOIN Prices p
    ON p.product_id = us.product_id
        AND p.start_date <= us.purchase_date
        AND us.purchase_date <= p.end_date
GROUP BY 1;
