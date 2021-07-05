create table placeorder_dogs(order_dogno int , orderuser_phoneno bigint not null, orderuser_address varchar(25) not null 
					  not null , status varchar(25) not null , user_id int
					   , order_id serial primary key   , 
							 order_date timestamp without time zone ,
							 delivery_date  timestamp without time zone );
							 
select * from placeorder_dogs;
 drop table placeorder_dogs; 