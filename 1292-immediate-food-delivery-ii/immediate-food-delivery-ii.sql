# Write your MySQL query statement below

with rnk as (

    select ROW_NUMBER() over (
        partition by(customer_id)
        order by order_date
    ) as ronum,
    customer_id, order_date, customer_pref_delivery_date 

    from delivery
)

select round(
            (count(
            case when ronum = 1 and order_date = customer_pref_delivery_date then 1 end
            ) * 100.0 / count(distinct customer_id)),
            2
    )as immediate_percentage 
from rnk