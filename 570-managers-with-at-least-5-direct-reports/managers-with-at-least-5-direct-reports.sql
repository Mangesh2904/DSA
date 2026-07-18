# Write your MySQL query statement below
select e.name 
from
(
select managerId, count(*)
from employee 
group by managerId
having count(*) > 4
) m left join employee e
on m.managerId = e.Id
where e.id = m.managerId
