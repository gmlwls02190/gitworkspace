select * from all_tables;
--=========================================================
drop table member;
drop table gallery;
drop table favArtist;
--=========================================================
select * from member;
select * from gallery;
select * from favArtist;
--=========================================================
delete MEMBER where id='zxc';
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
	wdate date default sysdate		-- �����
);

create table favArtist(
	favId int primary key,			-- �����۰���ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	artist varchar(30) not null,	-- �۰���
	wdate date default sysdate		-- �۰������
);
--=========================================================
insert into member values('qwe','qwe','tester','qweqwe','@naver.com','0','����','����','01051718893','USER');
insert into member values('asd','asd','��ѱⱸ��','ksh02190','@naver.com','�ּҹ���','01011112222','USER');