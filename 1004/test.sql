select * from all_tables;
drop table testboard;

create table testboard(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
select * from testboard;
insert into testboard (id,title,writer,content) values(1,'제목','ari','내용물');

create table testmember(
	id varchar(15) primary key,
	password varchar(10),
	name varchar(15),
	role varchar(15)
);
select * from testmember;
insert into testmember values('kim','1234','ari','USER');
insert into testmember values('admin','1234','admin','ADMIN');