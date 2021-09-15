select * from all_tables;
drop table message;
drop table reply;
create table users(
	userid varchar(15) primary key,
	uname varchar(15),
	userpw varchar(10),
	wdate date default sysdate
);
create table message(
	mid int primary key,
    userid varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0,
    wdate date default sysdate
);
create table reply(
	rid int primary key,
    mid int,
    userid varchar(15),
    wdate date default sysdate,
    rmsg varchar(50),
    constraint msgrp foreign key (mid) references message (mid) on delete cascade
);
insert into users values('timo','Æ¼¸ð','1234',sysdate);
insert into message values(1,'timo','±ÛÀÛ¼º',1,2,sysdate);
insert into reply values(1,1,'timo',sysdate,'´ñ±Û1');
insert into reply values(2,1,'timo',sysdate,'´ñ±Û2');
insert into message values(2,'timo','',2,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'´ñ±Û1');
insert into reply values(4,2,'timo',sysdate,'´ñ±Û2');
insert into reply values(5,2,'timo',sysdate,'´ñ±Û3');
insert into message values(3,'timo','È®ÀÎ',2,0,sysdate);

insert into users values('ksh02190','±èÈñÁø','1234',sysdate);
insert into message values(4,'ksh02190','test',1,2,sysdate);
insert into reply values(6,4,'ksh02190',sysdate,'´ñ±Û1');
insert into reply values(7,4,'ksh02190',sysdate,'´ñ±Û2');
insert into message values(5,'ksh02190','',2,1,sysdate);
insert into reply values(8,5,'ksh02190',sysdate,'´ñ±Û1');

select * from reply where rownum <= 2;
select * from users where userid = 'timo' and userpw= '1234';
select * from reply;
select * from message;
select * from users;
delete from users where userid = 'zxc';
delete from users where userid = 'qwer';
delete from users where userid = 'asdf';
select * from message where rownum <= 10 order by mid desc;
select * from (select * from message order by mid desc) where rownum between 2 and 4;

SELECT * FROM (SELECT ROWNUM AS RNUM, abc.* FROM( SELECT * FROM message ORDER BY mid DESC) abc ) abc WHERE RNUM BETWEEN 4 AND 5;