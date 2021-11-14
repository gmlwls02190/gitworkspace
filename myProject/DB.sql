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
	id varchar(15) primary key,		-- 아이디
	pw varchar(25) not null,		-- 비밀번호
	artist varchar(30) not null,	-- 작가명
	firstemail varchar(50) not null,-- 앞이메일
	lastemail varchar(50) not null,	-- 뒤이메일
	addrNum varchar(50) not null,	-- 우편번호
	roadAddr varchar(100) not null,	-- 주소
	detailAddr varchar(50),			-- 상세주소
	callNum varchar(15),			-- 핸드폰번호
	role varchar(15) not null		-- 회원분류
);

create table gallery(
	bid int primary key,			-- 작품번호
	id varchar(15) not null,		-- 회원아이디
	title varchar(60) not null,		-- 작품명
	artist varchar(30) not null,	-- 작가명
	info varchar(300),				-- 작품설명
	gallery varchar(500) not null,	-- 파일이름
	likeCnt int default 0,			-- 좋아요 갯수
	wdate date default sysdate		-- 등록일
);

create table favArt(
	favId int primary key,			-- 관심작품번호
	bid int not null,				-- 작품번호
	id varchar(15) not null,		-- 회원아이디
	title varchar(60) not null,		-- 작품명
	artist varchar(30) not null,	-- 작가명
	gallery varchar(500) not null,	-- 파일이름
	wdate date default sysdate		-- 작가등록일
);

create table heart(
	hid int primary key,			-- 좋아요번호
	bid int not null,				-- 작품번호
	id varchar(15) not null,		-- 회원아이디
	heart int default 0				-- 좋아요판별여부
);
--=========================================================

insert into HEART(hid,bid,id) values(1,3,'test');

insert into member values('qwe','qwe','tester','qweqwe','@naver.com','0','미정','미정','010-5171-8893','USER');
insert into member values('asd','asd','비둘기구구','ksh02190','@naver.com','주소','미정','미정','010-1111-2222','USER');

insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','작품명','비둘기구구','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','작품명','비둘기구구','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','작품명','비둘기구구','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','작품명','비둘기구구','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);
insert into gallery values((select nvl(max(bid),0)+1 from gallery),'asd','작품명','비둘기구구','asdasd','8e6230bf81vector-illustration-cloudy-sky-anime-style-vector-illustration-cloudy-sky-anime-style-116178376.jpg',1,sysdate);


