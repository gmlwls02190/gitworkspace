select * from all_tables;
--=========================================================
drop table member;
drop table gallery;
drop table favArt;
drop table heart;
--=========================================================
select * from member;
select * from gallery;
select * from favArt;
select * from heart;
--=========================================================
delete favArt where favId=2;
select * from GALLERY where rownum <=5;
select count(*) as cnt from gallery;
select * from (select rownum as rnum, a.* from (select * from favArt where id='asd' order by favId desc) a) where rnum between 1 and 3;
select * from (select rownum as rnum, a.* from (select * from gallery order by bid desc) a) where rnum between 2 and 4;
--=========================================================
create table member(
	id varchar(15) primary key,		-- ���̵�
	pw varchar(25) not null,		-- ��й�ȣ
	artist varchar(30) not null,	-- �۰���
	firstemail varchar(50) not null,-- ���̸���
	lastemail varchar(50) not null,	-- ���̸���
	addrNum varchar(50) not null,	-- �����ȣ
	roadAddr varchar(100) not null,	-- �ּ�
	detailAddr varchar(50),			-- ���ּ�
	callNum varchar(15),			-- �ڵ�����ȣ
	role varchar(15) not null		-- ȸ���з�
);

create table gallery(
	bid int primary key,			-- ��ǰ��ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	title varchar(60) not null,		-- ��ǰ��
	artist varchar(30) not null,	-- �۰���
	info varchar(300),				-- ��ǰ����
	gallery varchar(500) not null,	-- �����̸�
	likeCnt int default 0,			-- ���ƿ� ����
	wdate date default sysdate		-- �����
);

create table favArt(
	favId int primary key,			-- ������ǰ��ȣ
	bid int not null,				-- ��ǰ��ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	title varchar(60) not null,		-- ��ǰ��
	artist varchar(30) not null,	-- �۰���
	gallery varchar(500) not null,	-- �����̸�
	wdate date default sysdate		-- �۰������
);

create table heart(
	hid int primary key,			-- ���ƿ��ȣ
	bid int not null,				-- ��ǰ��ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	heart int default 0				-- ���ƿ��Ǻ�����
);
--=========================================================

insert into HEART(hid,bid,id) values(1,3,'test');

insert into member values('qwe','qwe','tester','qweqwe','@naver.com','0','����','����','010-5171-8893','USER');
insert into member values('asd','asd','��ѱⱸ��','ksh02190','@naver.com','�ּ�','����','����','010-1111-2222','USER');

insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','��ǰ��','��ѱⱸ��','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','��ǰ��','��ѱⱸ��','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','��ǰ��','��ѱⱸ��','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','��ǰ��','��ѱⱸ��','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','��ǰ��','��ѱⱸ��','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);


