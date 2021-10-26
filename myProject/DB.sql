select * from all_tables;
--=========================================================
drop table member;
drop table board;
--=========================================================
select * from member;
select * from gallery;
--=========================================================
create table member(
	id varchar(15) primary key,		-- 아이디
	kakaoId varchar(30),			-- 카카오아이디
	pw varchar(10) not null,		-- 비밀번호
	artist varchar(30) not null,	-- 작가명
	email varchar(50) not null,		-- 이메일
	address varchar(50) not null,	-- 주소
	callNum int not null,			-- 핸드폰번호
	role varchar(15) not null		-- 회원분류
);

create table gallery(
	bid int primary key,			-- 작품번호
	id varchar(15) not null,		-- 회원아이디
	title varchar(60) not null,		-- 작품명
	artist varchar(30) not null,	-- 작가명
	info varchar(300),				-- 작품설명
	gallery varchar(50) not null,	-- 파일이름
	wdate date default sysdate		-- 등록일
);

create table favArtist(
	favId int primary key,			-- 관심작가번호
	bid int not null,				-- 작품번호
	id varchar(15) not null,		-- 회원아이디
	title varchar(60) not null,		-- 작품명
	artist varchar(30) not null,	-- 작가명
	wdate date default sysdate		-- 작가등록일
);