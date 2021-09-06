select * from all_tables;
drop table HG_AIR;
create table member(
	userid varchar(15) primary key,
	userpw varchar(15) not null,
	username varchar(30) not null
);
select * from member;
insert into member values('ksh02190','1234','±èÈñÁø')

create table board(
	bnum int primary key,
	writer varchar(30) not null,
	title varchar(30) not null,
	content varchar(100) not null,
	userid varchar(15) not null
);
select * from board;
insert into board values(1,'±èÈñÁø','Å×½ºÆ®','Å×½ºÆ®»ùÇÃµ¥ÀÌÅÍ','ksh02190');