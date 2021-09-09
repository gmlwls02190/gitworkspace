create table bank1(
	b1id int primary key,
	b1name varchar(20),
	b1balance int
);

create table bank2(
	b2id int primary key,
	b2name varchar(20),
	b2balance int
);

select * from all_tables;

drop table bank1;
drop table bank2;

select * from bank2;

insert into bank1 values(101,'°¡·»',30000);
insert into bank2 values(201,'ÆÄÀÌÅ©',4000);