use northwind;

/*Question 1
 What are the categories of products in the database?*/

select distinct category
from products p;



/*Question 2
 What products are made by Dell?*/

select * 
from products p 
where product_name like "%Dell%"



/*Question 3
 List all the orders shipped to Pennsylvania.*/

select * 
from orders o 
where ship_state = "Pennsylvania";



/*Question 4
 List the first name and last name of all employees with last names that start with the letter W.*/

select last_name, first_name 
from employees e 
where last_name like "W%";



/*Question 5
 List all customers from zip codes that start with 55.*/

select *
from customers c 
where postal_code like "55%";



/*Question 6
 List all customers from zip codes that end with 0.*/

select *
from customers c 
where postal_code like "%0";
 


/*Question 7
 List the first name, last name, and email for all customers with a ".org" email address.*/

select last_name, first_name, email
from customers c 
where email like "%.org";



/*Question 8
 List the first name, last name, and phone number for all customers from the 202 area code.*/

select last_name, first_name, phone
from customers c 
where phone like "%(202)%";



/*Question 9
 List the first name, last name, and phone number for all customers from the 202 area code, 
 ordered by last name, first name.*/

select last_name, first_name, phone
from customers c 
where phone like "%(202)%"
order by last_name, first_name; 
