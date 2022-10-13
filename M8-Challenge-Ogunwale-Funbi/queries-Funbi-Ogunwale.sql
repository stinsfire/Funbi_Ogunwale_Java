use sakila;

/*Question 1
 Write a SQL query to find the total rental amount paid for each film.
 Your query should return the following columns: film_id, total_amount*/

select film_id , SUM(p.amount) as total_amount
from payment p
join rental as r on p.rental_id=r.rental_id
join inventory i on i.inventory_id=r.inventory_id
group by film_id;



----------------------------------------------------------------
/*Question 2
 Create a view named total_rental_amount using the query from the previous step.*/

CREATE VIEW total_rental_amount AS
select film_id , SUM(p.amount) as total_amount
from payment p
join rental as r on p.rental_id=r.rental_id
join inventory i on i.inventory_id=r.inventory_id
group by film_id;



-----------------------------------------------------------
/*Question 3
 Write a SQL query to find the total number of copies in inventory for each film.
 Your query should return the following columns: film_id, total_copies*/

select film_id, count(film_id)  as total_copies
from inventory i 
group by film_id;


-------------------------------------------------------------
/*Question 4
 Create a view named total_film_copies  using the query from the previous step.*/

CREATE VIEW total_film_copies  as
select film_id, count(film_id)  as total_copies
from inventory i 
group by film_id;



------------------------------------------------------------------------
/*Question 5
 Write a SQL query that combines data from the film table, the total_rental_amount view,
 and the total_film_copies view to find all films with a total rental amount greater  
 than 200.00, and display the following columns: 
 film_id, title, description, rental_duration, rental_rate, replacement_cost rating, total_copies, total_amount*/

select f.film_id, title, description, rental_duration, rental_rate, replacement_cost, rating, total_copies, total_amount
from film f 
join total_rental_amount as tra on tra.film_id= f.film_id
join total_film_copies as tfc on tfc.film_id=tra.film_id
where total_amount > 200;