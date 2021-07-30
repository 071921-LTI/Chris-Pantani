create table customers(
	cus_id SERIAL primary key,
	cus_username VARCHAR(50) not null unique,
	cus_password VARCHAR(40) not null,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(75)
);

create table employees(
	empl_id SERIAL primary key,
	empl_username VARCHAR(50) not null unique,
	empl_password VARCHAR(40) not null,
	first_name VARCHAR(20),
	last_name VARCHAR(20), 
	email VARCHAR(75)
);

create table items(
	item_id SERIAL primary key,
	item_name VARCHAR(50),
	price_offered numeric (7,2),
	payment_made numeric (7,2),
	offer_pending BOOLEAN,
	item_description text,
	item_sold BOOLEAN not null,
	customer INTEGER references customers(cus_id),
	employee INTEGER references employees(empl_id)
);

