create table users (
	user_id int primary key,
    name varchar(30) not null,
    password varchar(10) not null,
    phone varchar(10) unique not null,	
    email varchar(50) unique not null,
	role varchar(10) not null check(role in ('customer', 'admin'))
);


