

-- Q.Find all the products with category = Apple Devices.
select c1_0.user_id,
       c1_0.name,
       p1_0.category_user_id,
       p1_0.user_id,
       p1_0.description,
       p1_0.image,
       p1_0.price,
       p1_0.title
from category c1_0
         left join products p1_0 on c1_0.user_id = p1_0.category_user_id
where c1_0.user_id = ?