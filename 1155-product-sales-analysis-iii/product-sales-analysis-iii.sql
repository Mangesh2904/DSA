
with sales_yr as(
    select *, min(year) over (
        partition by product_id
        order by year
    ) as mini
    from sales
)

select product_id, 
year as first_year ,
quantity, 
price
from  sales_yr
where year = mini
