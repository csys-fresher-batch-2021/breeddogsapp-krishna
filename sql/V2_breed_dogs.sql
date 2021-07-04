create table breed_dogs(dog_no serial primary key , dog_age int , dog_name varchar(25) not null 
					   , dog_gender varchar(25) not null , dog_place varchar(25) not null
					   , dog_price int , dog_insurance varchar(25) , sold_status boolean default false
					   , dog_image bytea)
drop table breed_dogs;
select*from breed_dogs;