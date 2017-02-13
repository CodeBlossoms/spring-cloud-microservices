create table users (
	user_id int primary key,
    name varchar(30) not null,
    password varchar(10) not null,
    phone varchar(10) unique not null,	
    email varchar(50) unique not null,
	role varchar(10) not null check(role in ('customer', 'admin'))
);


create table cars (
	car_id int primary key,
    model varchar(30) not null,
    rent_per_hr number(10,2) not null
);

create table rental_orders (
	order_id int primary key auto_increment,
	car_id int not null,
	user_id int not null,
	car_rent_approved bit default 0,
	car_return_received bit default 0,
	car_return_approved bit default 0,
	constraint fk_user_id
    foreign key (user_id) references users(user_id) on update cascade on delete no action,
	constraint fk_car_id
    foreign key (car_id) references cars(car_id) on update cascade on delete no action
	
);



