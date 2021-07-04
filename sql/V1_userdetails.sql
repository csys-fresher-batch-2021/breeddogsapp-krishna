create table userdetails(username varchar(50) not null,emailid varchar(50) not null unique
, password varchar(50) not null , city varchar(50) not null
, phonenumber bigint unique , id serial primary key);

DROP TABLE userdetails;
select * from userdetails;