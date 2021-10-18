select * from all_tables;
drop table testmember;
drop table testboard;

create table testmember(
	id varchar(15) primary key,
	pw varchar(20) not null,
	name varchar(30) not null
);
select * from TESTMEMBER;
insert into testmember values('qwe','qwe','tester');

create table testboard(
	bid int primary key,
	id varchar(15) not null,
	writer varchar(30) not null,
	title varchar(50) not null,
	content varchar(100) not null,
	wdate date default sysdate not null
);
select * from testboard;
insert into TESTBOARD values(1,'qwe','tester','test1','test1',sysdate);
insert into TESTBOARD values(2,'qwe','tester','test2','test2',sysdate);
