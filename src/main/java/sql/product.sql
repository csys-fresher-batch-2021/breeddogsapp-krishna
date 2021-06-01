CREATE TABLE stock
(
Dog_NO int not null check ( quantity between 1 and 1000) primary key,
Dog_Name varchar(20) not null,
Dog_Age varchar(20) not null,
Dog_Gender varchar(20) not null,
Dog_Location date not null,
Dog_Price int not null check ( quantity between 1 and 1000),
Dog_Insurance  varchar(20) not null
);



