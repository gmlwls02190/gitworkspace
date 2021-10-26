select * from all_tables;
--=========================================================
drop table member;
drop table board;
--=========================================================
select * from member;
select * from gallery;
--=========================================================
create table member(
	id varchar(15) primary key,		-- ���̵�
	kakaoId varchar(30),			-- īī�����̵�
	pw varchar(10) not null,		-- ��й�ȣ
	artist varchar(30) not null,	-- �۰���
	email varchar(50) not null,		-- �̸���
	address varchar(50) not null,	-- �ּ�
	callNum int not null,			-- �ڵ�����ȣ
	role varchar(15) not null		-- ȸ���з�
);

create table gallery(
	bid int primary key,			-- ��ǰ��ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	title varchar(60) not null,		-- ��ǰ��
	artist varchar(30) not null,	-- �۰���
	info varchar(300),				-- ��ǰ����
	gallery varchar(50) not null,	-- �����̸�
	wdate date default sysdate		-- �����
);

create table favArtist(
	favId int primary key,			-- �����۰���ȣ
	bid int not null,				-- ��ǰ��ȣ
	id varchar(15) not null,		-- ȸ�����̵�
	title varchar(60) not null,		-- ��ǰ��
	artist varchar(30) not null,	-- �۰���
	wdate date default sysdate		-- �۰������
);