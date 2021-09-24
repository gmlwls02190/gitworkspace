SELECT * FROM ALL_TABLES;
-- ���� ���̺�
DROP TABLE MEMBER;
-- �Խ��� ���̺�
DROP TABLE FREEBOARD;
DROP TABLE STUDYBOARD;
DROP TABLE NOTICEBOARD;
-- ���ɱ� ���̺�
DROP TABLE CONCERM;
-- �Խ��� ��� ���̺�
DROP TABLE FREECOMMENT;
DROP TABLE STUDYCOMMENT;
DROP TABLE NOTICECOMMENT;
-- ���� ���̺�
CREATE TABLE MEMBER(
	MID VARCHAR(50) PRIMARY KEY,				-- ȸ�� ���̵�
	MPW VARCHAR(50) NOT NULL,					-- ȸ�� ��й�ȣ
	MNAME VARCHAR(50) NOT NULL,					-- ȸ�� �г���
	MEMAIL VARCHAR(50) NOT NULL,				-- ȸ�� �̸���
	ROLE VARCHAR(20) DEFAULT 'user' NOT NULL 	-- �����/������
);
INSERT INTO MEMBER (MID,MPW,MNAME,MEMAIL) VALUES ('qwqw','qwqw','�ϳ�','hana11@naver.com');
select * from MEMBER;
INSERT INTO MEMBER VALUES ('qwe','qwe','�ϳ�','hana11@naver.com','user');
INSERT INTO MEMBER VALUES ('admin','1004','������','admin@helper.com','admin');
insert into MEMBER values('asd','asd', '��', 'a@naver.com','user');
insert into MEMBER values('zxc','zxc', '��', 'c@naver.com','user');
insert into MEMBER values('123','123', '��', 'e@naver.com','user');
UPDATE MEMBER SET  MPW='11', MNAME ='11', MEMAIL='11@naver.com', ROLE='admin' where MID='Z123';
DELETE FROM MEMBER WHERE MID='f123';
-- ====================================================================
-- �Խñ� ���̺� 
CREATE TABLE FREEBOARD(					 -- �����Խ���
	PNUM INT PRIMARY KEY, 				 -- �Խñ� ���� ��ȣ
	PTITLE VARCHAR(50) NOT NULL,		 -- �Խñ� ���� 
	PCONTENT VARCHAR(1000) NOT NULL,	 -- �Խñ� ����
	PDATE DATE DEFAULT SYSDATE NOT NULL, -- �Խñ� �ۼ����� 
	MNAME VARCHAR(50) NOT NULL,			 -- ȸ�� �г���
	MID VARCHAR(50) NOT NULL,			 -- ȸ�� ���̵�
	CNT INT DEFAULT 0 NOT NULL, 					 -- ��ȸ��
	CATEGORY VARCHAR(50) DEFAULT 'Free' NOT NULL 		 -- ī�װ� 
);
select * from FREEBOARD;
--insert into FREEBOARD values(������ȣ,����,����,�ۼ���,�г���,���̵�,��ȸ��,ī�װ�);
insert into FREEBOARD values(1,'1��','test1',sysdate,'�ϳ�','qwe',0,'Free');
insert into FREEBOARD values(2,'2��','test2',sysdate,'�ϳ�','qwe',0,'Free');
insert into FREEBOARD values(3,'3��','test3',sysdate,'��','zxc',0,'Free');
insert into FREEBOARD values(4,'4��','test4',sysdate,'��','123',0,'Free');
insert into FREEBOARD values(5,'5��','test5',sysdate,'��','123',0,'Free');
-- �Խñ� ����Ʈ ����
SELECT * FROM FREEBOARD ORDER BY PNUM DESC; --�ֽű� 
SELECT * FROM FREEBOARD WHERE PTITLE= LIKE '%H%' ORDER BY PNUM DESC;  --����
-- �Խñ� �� ����
SELECT * FROM FREEBOARD WHERE MID = 'qwe' ;
-- �Խñ� �ۼ�
INSERT INTO FREEBOARD VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM FREEBOARD),'Hello','hellow world',SYSDATE,'hana','�ϳ�',0);
INSERT INTO FREEBOARD (PNUM,PTITLE,PCONTENT,MNAME,MID) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM FREEBOARD),'Hello','hellow world','�ϳ�','hana');
-- ����
UPDATE FREEBOARD SET PTITLE='HI',PCONTENT='�ڡڡڡڡڡڡڡڡ�' WHERE PNUM=1;
-- ����
DELETE FROM FREEBOARD WHERE PNUM ='2' AND MID='duri';

CREATE TABLE STUDYBOARD(							-- ���͵�Խ���
	PNUM INT PRIMARY KEY, 				 			-- �Խñ� ���� ��ȣ
	PTITLE VARCHAR(50) NOT NULL,		 			-- �Խñ� ���� 
	PCONTENT VARCHAR(1000) NOT NULL,	 			-- �Խñ� ����
	PDATE DATE DEFAULT SYSDATE NOT NULL, 			-- �Խñ� �ۼ����� 
	MNAME VARCHAR(50) NOT NULL,			 			-- ȸ�� �г���
	MID VARCHAR(50) NOT NULL,			 			-- ȸ�� ���̵�
	CNT INT DEFAULT 0 NOT NULL, 					-- ��ȸ��
	CATEGORY VARCHAR(50) DEFAULT 'Study' NOT NULL 	-- ī�װ� 
);
select * from STUDYBOARD;
insert into STUDYBOARD values(1,'1��','test1',sysdate,'�ϳ�','qwe',0,'Study');
insert into STUDYBOARD values(2,'2��','test2',sysdate,'�ϳ�','qwe',0,'Study');
insert into STUDYBOARD values(3,'3��','test3',sysdate,'��','zxc',0,'Study');
insert into STUDYBOARD values(4,'4��','test4',sysdate,'��','123',0,'Study');
insert into STUDYBOARD values(5,'5��','test5',sysdate,'��','123',0,'Study');

CREATE TABLE NOTICEBOARD(							-- �����Խ���
	PNUM INT PRIMARY KEY, 						 	-- �Խñ� ���� ��ȣ
	PTITLE VARCHAR(50) NOT NULL,		 		 	-- �Խñ� ���� 
	PCONTENT VARCHAR(1000) NOT NULL,			 	-- �Խñ� ����
	PDATE DATE DEFAULT SYSDATE NOT NULL, 		 	-- �Խñ� �ۼ����� 
	MNAME VARCHAR(50) NOT NULL,			 	   	 	-- ȸ�� �г���
	MID VARCHAR(50) NOT NULL,					 	-- ȸ�� ���̵�
	CNT INT DEFAULT 0 NOT NULL, 				 	-- ��ȸ��
	CATEGORY VARCHAR(50) DEFAULT '��������' NOT NULL 	-- ī�װ� 
);
select * from NOTICEBOARD;
insert into NOTICEBOARD values(1,'1��','test1',sysdate,'������','admin',0,'��������');
insert into NOTICEBOARD values(2,'2��','test2',sysdate,'������','admin',0,'��������');
insert into NOTICEBOARD values(3,'3��','test3',sysdate,'������','admin',0,'��������');
insert into NOTICEBOARD values(4,'4��','test4',sysdate,'������','admin',0,'��������');
insert into NOTICEBOARD values(5,'5��','test5',sysdate,'������','admin',0,'��������');
-- ====================================================================
-- ���ɱ� �Խñ� ���̺� 
CREATE TABLE CONCERM(
	FAVNUM INT PRIMARY KEY,				 -- ���� �Խñ� ���� ��ȣ  
	MID VARCHAR(50) NOT NULL,			 -- ȸ�� ���̵�
	PNUM INT NOT NULL, 					 -- �Խñ� ��ȣ
	CATEGORY VARCHAR(50) NOT NULL		 -- ī�װ�

);
-- ���ɱ� ��� ����
SELECT * FROM CONCERM ORDER BY FAVNUM DESC;
-- ���ɱ� ��� 
INSERT INTO CONCERM VALUES ((SELECT NVL(MAX(FAVNUM),0)+1 FROM CONCERM),'qwe','1','Free');
-- ���ɱ� ���� 
DELETE FROM CONCERM WHERE FAVNUM =1 AND MID='hana';
-- ====================================================================
-- ������̺� 
CREATE TABLE FREECOMMENT(				 -- �����Խ��� ���
	CNUM INT PRIMARY KEY,				 -- ��� ���� ��ȣ 
	FCOMMENT VARCHAR(200) NOT NULL,		 -- ��� ���� 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- ��� �ۼ� ����
	PNUM INT NOT NULL,					 -- �Խñ� ��ȣ  
	MNAME VARCHAR(50) NOT NULL, 		 -- ȸ�� �г���
	MID VARCHAR(50) NOT NULL			 -- ȸ�� ���̵� 
);

CREATE TABLE STUDYCOMMENT(				 -- ���͵�Խ��� ���
	CNUM INT PRIMARY KEY,				 -- ��� ���� ��ȣ 
	SCOMMENT VARCHAR(200) NOT NULL,		 -- ��� ���� 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- ��� �ۼ� ����
	PNUM INT NOT NULL,					 -- �Խñ� ��ȣ  
	MNAME VARCHAR(50) NOT NULL, 		 -- ȸ�� �г���
	MID VARCHAR(50) NOT NULL			 -- ȸ�� ���̵� 
);

CREATE TABLE NOTICECOMMENT(				 -- �����Խ��� ���
	CNUM INT PRIMARY KEY,				 -- ��� ���� ��ȣ 
	NCOMMENT VARCHAR(200) NOT NULL,		 -- ��� ���� 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- ��� �ۼ� ����
	PNUM INT NOT NULL,				 	 -- �Խñ� ��ȣ  
	MNAME VARCHAR(50) NOT NULL, 		 -- ȸ�� �г���
	MID VARCHAR(50) NOT NULL			 -- ȸ�� ���̵� 
);