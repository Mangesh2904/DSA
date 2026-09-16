
with max_sal as (
    select dense_rank() over(
        partition by e.departmentId
        order by e.salary desc
    ) as rnk, 
    d.name as Department,
    e.name as Employee,
    e.salary 
    from employee e 
    left join
    department d
    on e.departmentId = d.id
)
select 
Department,
Employee,
salary
from max_sal
where rnk <=3