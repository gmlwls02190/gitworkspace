select * from all_tables;
drop table member;
create table member(
	mname varchar(30) not null,
	mid varchar(15) primary key,
	mpw varchar(15) not null
);
select * from member;
insert into member values('±èÈñÁø','ksh02190','1234');
delete from member;
