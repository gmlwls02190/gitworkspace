create table message(
	mnum int primary key,
	writer varchar(15) not null,
	title varchar(15) not null,
	content varchar(100) not null,
	wdate date default sysdate,
	userid varchar(15) not null
);
select * from message;
/*���õ����� : �Ϲ������� ���� �ɶ����� ���õ����Ͱ� ����!*/
insert into message values(1,'kim','title','content',sysdate,'ksh02190');
insert into message values(2,'kim2','title2','content2',sysdate,'gmlwls02190');

create table wuser(
	uname varchar(20) not null,
	userid varchar(15) primary key,
	userpw varchar(15) not null
);
select * from wuser;
insert into wuser values('������','ksh02190','123123');
insert into wuser values('����Ŵ','gmlwls02190','123123');
drop table wuser;