create table product(
	pnum int primary key,
	pname varchar(20),
	pcnt int,
	pstatus varchar(20)
);
select * from product;
insert into product values(1,'���',5,'��ȣ');
drop table product;