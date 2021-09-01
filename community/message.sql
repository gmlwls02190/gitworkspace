create table message(
	mnum int primary key,
	writer varchar(15) not null,
	title varchar(15) not null,
	content varchar(100) not null,
	wdate date default sysdate,
	userid varchar(15) not null
);
select * from message;
/*샘플데이터 : 일반적으로 서비스 될때에는 샘플데이터가 있음!*/
insert into message values(1,'kim','title','content',sysdate,'ksh02190');
insert into message values(2,'kim2','title2','content2',sysdate,'gmlwls02190');
select * from message where lower(title) like lower('%T%');

create table wuser(
	uname varchar(20) not null,
	userid varchar(15) primary key,
	userpw varchar(15) not null
);
select * from wuser;
insert into wuser values('김희진','ksh02190','123123');
insert into wuser values('희진킴','gmlwls02190','123123');
drop table comments;

create table comments(
	cnum int primary key,
	mnum int not null,
	cname varchar(15) not null,
	comments varchar(100) not null,
	cdate date default sysdate
);
select * from comments;
insert into comments values(1,1,'티모','반갑다',sysdate);