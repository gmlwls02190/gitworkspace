create table message(
	mnum int primary key,
	writer varchar(15) not null,
	title varchar(15) not null,
	content varchar(100) not null,
	wdate date default sysdate
);
select * from message;
/*���õ����� : �Ϲ������� ���� �ɶ����� ���õ����Ͱ� ����!*/
insert into message values(1,'kim','title','content',sysdate);
insert into message values(2,'kim2','title2','content2',sysdate);