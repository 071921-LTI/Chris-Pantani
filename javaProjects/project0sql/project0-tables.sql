create table customers(
	cus_id SERIAL primary key,
	cus_username VARCHAR(50) not null unique,
	cus_password VARCHAR(40) not null,
	cus_first_name VARCHAR(20),
	cus_last_name VARCHAR(20),
	cus_email VARCHAR(75)
);

create table employees(
	empl_id SERIAL primary key,
	empl_username VARCHAR(50) not null unique,
	empl_password VARCHAR(40) not null,
	empl_first_name VARCHAR(20),
	empl_last_name VARCHAR(20), 
	empl_email VARCHAR(75)
);

create table items(
	item_id SERIAL primary key,
	item_name VARCHAR(50),
	price_offered numeric (7,2),
	payment_made numeric (7,2),
	offer_pending BOOLEAN,
	item_description TEXT,
	item_sold BOOLEAN not null,
	employee INTEGER references employees(empl_id),
	customer INTEGER references customers(cus_id)
);

create table offers(
	offer_id SERIAL primary key,
	item INTEGER references items(item_id),
	customer INTEGER references customers(cus_id),
	price_offered NUMERIC(7,2)
);

--drop table items, employees, customers;

--drop table customers, employees, items;