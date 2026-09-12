# Write your MySQL query statement below
select p.product_id, round(
   ifnull( sum(p.price * s.units)/sum(s.units), 0), 2
) as average_price

from Prices p left join UnitsSold s

on p.product_id  = s.product_id 

and s.purchase_date between p.start_date and p.end_date

group by(product_id)