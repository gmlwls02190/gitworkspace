select * from all_tables;
drop table member;
drop table board;

create table board(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
select * from board;

insert into board values(1,'11','hello','qweqwe',sysdate);
insert into board values(2,'22','hello','weqweq',sysdate);
insert into board values(3,'33','hello','eqweqw',sysdate);
insert into board values(4,'44','hello','asdasd',sysdate);

select * from board where title like '%Á¦¸ñ%';
select * from board where title like '%Á¦%';

create table member(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);
select * from member;

insert into member values('qwe','qwe','hello','USER');