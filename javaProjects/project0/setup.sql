

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
);

create table offers(
	offer_id SERIAL primary key,

	price_offered NUMERIC(7,2)
);

insert into employees (empl_username, empl_password, empl_first_name, empl_last_name, empl_email) values ('testEmployee', 'testPassword', 'John ', 'Doe', 'jathFmUDCbL');