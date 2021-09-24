SELECT * FROM ALL_TABLES;
-- 유저 테이블
DROP TABLE MEMBER;
-- 게시판 테이블
DROP TABLE FREEBOARD;
DROP TABLE STUDYBOARD;
DROP TABLE NOTICEBOARD;
-- 관심글 테이블
DROP TABLE CONCERM;
-- 게시판 댓글 테이블
DROP TABLE FREECOMMENT;
DROP TABLE STUDYCOMMENT;
DROP TABLE NOTICECOMMENT;
-- 유저 테이블
CREATE TABLE MEMBER(
	MID VARCHAR(50) PRIMARY KEY,				-- 회원 아이디
	MPW VARCHAR(50) NOT NULL,					-- 회원 비밀번호
	MNAME VARCHAR(50) NOT NULL,					-- 회원 닉네임
	MEMAIL VARCHAR(50) NOT NULL,				-- 회원 이메일
	ROLE VARCHAR(20) DEFAULT 'user' NOT NULL 	-- 사용자/관리자
);
INSERT INTO MEMBER (MID,MPW,MNAME,MEMAIL) VALUES ('qwqw','qwqw','하나','hana11@naver.com');
select * from MEMBER;
INSERT INTO MEMBER VALUES ('qwe','qwe','하나','hana11@naver.com','user');
INSERT INTO MEMBER VALUES ('admin','1004','관리자','admin@helper.com','admin');
insert into MEMBER values('asd','asd', '일', 'a@naver.com','user');
insert into MEMBER values('zxc','zxc', '삼', 'c@naver.com','user');
insert into MEMBER values('123','123', '오', 'e@naver.com','user');
UPDATE MEMBER SET  MPW='11', MNAME ='11', MEMAIL='11@naver.com', ROLE='admin' where MID='Z123';
DELETE FROM MEMBER WHERE MID='f123';
-- ====================================================================
-- 게시글 테이블 
CREATE TABLE FREEBOARD(					 -- 자유게시판
	PNUM INT PRIMARY KEY, 				 -- 게시글 고유 번호
	PTITLE VARCHAR(50) NOT NULL,		 -- 게시글 제목 
	PCONTENT VARCHAR(1000) NOT NULL,	 -- 게시글 내용
	PDATE DATE DEFAULT SYSDATE NOT NULL, -- 게시글 작성일자 
	MNAME VARCHAR(50) NOT NULL,			 -- 회원 닉네임
	MID VARCHAR(50) NOT NULL,			 -- 회원 아이디
	CNT INT DEFAULT 0 NOT NULL, 					 -- 조회수
	CATEGORY VARCHAR(50) DEFAULT 'Free' NOT NULL 		 -- 카테고리 
);
select * from FREEBOARD;
--insert into FREEBOARD values(고유번호,제목,내용,작성일,닉네임,아이디,조회수,카테고리);
insert into FREEBOARD values(1,'1번','test1',sysdate,'하나','qwe',0,'Free');
insert into FREEBOARD values(2,'2번','test2',sysdate,'하나','qwe',0,'Free');
insert into FREEBOARD values(3,'3번','test3',sysdate,'삼','zxc',0,'Free');
insert into FREEBOARD values(4,'4번','test4',sysdate,'오','123',0,'Free');
insert into FREEBOARD values(5,'5번','test5',sysdate,'오','123',0,'Free');
-- 게시글 리스트 보기
SELECT * FROM FREEBOARD ORDER BY PNUM DESC; --최신글 
SELECT * FROM FREEBOARD WHERE PTITLE= LIKE '%H%' ORDER BY PNUM DESC;  --수정
-- 게시글 상세 보기
SELECT * FROM FREEBOARD WHERE MID = 'qwe' ;
-- 게시글 작성
INSERT INTO FREEBOARD VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM FREEBOARD),'Hello','hellow world',SYSDATE,'hana','하나',0);
INSERT INTO FREEBOARD (PNUM,PTITLE,PCONTENT,MNAME,MID) VALUES ((SELECT NVL(MAX(PNUM),0)+1 FROM FREEBOARD),'Hello','hellow world','하나','hana');
-- 수정
UPDATE FREEBOARD SET PTITLE='HI',PCONTENT='★★★★★★★★★' WHERE PNUM=1;
-- 삭제
DELETE FROM FREEBOARD WHERE PNUM ='2' AND MID='duri';

CREATE TABLE STUDYBOARD(							-- 스터디게시판
	PNUM INT PRIMARY KEY, 				 			-- 게시글 고유 번호
	PTITLE VARCHAR(50) NOT NULL,		 			-- 게시글 제목 
	PCONTENT VARCHAR(1000) NOT NULL,	 			-- 게시글 내용
	PDATE DATE DEFAULT SYSDATE NOT NULL, 			-- 게시글 작성일자 
	MNAME VARCHAR(50) NOT NULL,			 			-- 회원 닉네임
	MID VARCHAR(50) NOT NULL,			 			-- 회원 아이디
	CNT INT DEFAULT 0 NOT NULL, 					-- 조회수
	CATEGORY VARCHAR(50) DEFAULT 'Study' NOT NULL 	-- 카테고리 
);
select * from STUDYBOARD;
insert into STUDYBOARD values(1,'1번','test1',sysdate,'하나','qwe',0,'Study');
insert into STUDYBOARD values(2,'2번','test2',sysdate,'하나','qwe',0,'Study');
insert into STUDYBOARD values(3,'3번','test3',sysdate,'삼','zxc',0,'Study');
insert into STUDYBOARD values(4,'4번','test4',sysdate,'오','123',0,'Study');
insert into STUDYBOARD values(5,'5번','test5',sysdate,'오','123',0,'Study');

CREATE TABLE NOTICEBOARD(							-- 공지게시판
	PNUM INT PRIMARY KEY, 						 	-- 게시글 고유 번호
	PTITLE VARCHAR(50) NOT NULL,		 		 	-- 게시글 제목 
	PCONTENT VARCHAR(1000) NOT NULL,			 	-- 게시글 내용
	PDATE DATE DEFAULT SYSDATE NOT NULL, 		 	-- 게시글 작성일자 
	MNAME VARCHAR(50) NOT NULL,			 	   	 	-- 회원 닉네임
	MID VARCHAR(50) NOT NULL,					 	-- 회원 아이디
	CNT INT DEFAULT 0 NOT NULL, 				 	-- 조회수
	CATEGORY VARCHAR(50) DEFAULT '공지사항' NOT NULL 	-- 카테고리 
);
select * from NOTICEBOARD;
insert into NOTICEBOARD values(1,'1번','test1',sysdate,'관리자','admin',0,'공지사항');
insert into NOTICEBOARD values(2,'2번','test2',sysdate,'관리자','admin',0,'공지사항');
insert into NOTICEBOARD values(3,'3번','test3',sysdate,'관리자','admin',0,'공지사항');
insert into NOTICEBOARD values(4,'4번','test4',sysdate,'관리자','admin',0,'공지사항');
insert into NOTICEBOARD values(5,'5번','test5',sysdate,'관리자','admin',0,'공지사항');
-- ====================================================================
-- 관심글 게시글 테이블 
CREATE TABLE CONCERM(
	FAVNUM INT PRIMARY KEY,				 -- 관심 게시글 고유 번호  
	MID VARCHAR(50) NOT NULL,			 -- 회원 아이디
	PNUM INT NOT NULL, 					 -- 게시글 번호
	CATEGORY VARCHAR(50) NOT NULL		 -- 카테고리

);
-- 관심글 목록 보기
SELECT * FROM CONCERM ORDER BY FAVNUM DESC;
-- 관심글 등록 
INSERT INTO CONCERM VALUES ((SELECT NVL(MAX(FAVNUM),0)+1 FROM CONCERM),'qwe','1','Free');
-- 관심글 삭제 
DELETE FROM CONCERM WHERE FAVNUM =1 AND MID='hana';
-- ====================================================================
-- 댓글테이블 
CREATE TABLE FREECOMMENT(				 -- 자유게시판 댓글
	CNUM INT PRIMARY KEY,				 -- 댓글 고유 번호 
	FCOMMENT VARCHAR(200) NOT NULL,		 -- 댓글 내용 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- 댓글 작성 일자
	PNUM INT NOT NULL,					 -- 게시글 번호  
	MNAME VARCHAR(50) NOT NULL, 		 -- 회원 닉네임
	MID VARCHAR(50) NOT NULL			 -- 회원 아이디 
);

CREATE TABLE STUDYCOMMENT(				 -- 스터디게시판 댓글
	CNUM INT PRIMARY KEY,				 -- 댓글 고유 번호 
	SCOMMENT VARCHAR(200) NOT NULL,		 -- 댓글 내용 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- 댓글 작성 일자
	PNUM INT NOT NULL,					 -- 게시글 번호  
	MNAME VARCHAR(50) NOT NULL, 		 -- 회원 닉네임
	MID VARCHAR(50) NOT NULL			 -- 회원 아이디 
);

CREATE TABLE NOTICECOMMENT(				 -- 공지게시판 댓글
	CNUM INT PRIMARY KEY,				 -- 댓글 고유 번호 
	NCOMMENT VARCHAR(200) NOT NULL,		 -- 댓글 내용 
	CDATE DATE DEFAULT SYSDATE NOT NULL, -- 댓글 작성 일자
	PNUM INT NOT NULL,				 	 -- 게시글 번호  
	MNAME VARCHAR(50) NOT NULL, 		 -- 회원 닉네임
	MID VARCHAR(50) NOT NULL			 -- 회원 아이디 
);