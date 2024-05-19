CREATE TABLE public.users (
	id int4 NOT NULL,
	"name" varchar NOT NULL,
	age int4 NOT NULL,
	rating numeric DEFAULT 0.0 NULL,
	payment numeric NULL,
	active bool NULL,
	country varchar NULL,
	currency varchar(3) NULL,
	bio varchar(40) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);