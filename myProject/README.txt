===================================================================================
===============================프로젝트진행사항========================================
===================================================================================

10.26
===================================================================================
전체적인 .jsp페이지 뷰 부분 기본구조 작성 및 수정
각모델부분 Service / ServiceImpl 생성
DB테이블 일부 수정

카카오 로그인 API 적용 준비
===================================================================================

10.27
===================================================================================
일부 css 조정
카카오 로그인 API 적용(DB 저장 미구현)
메뉴바태그 수정
파일입출력 구현 및 DB 저장 완료
파일입출력을 위해 galleryVO 수정
톰캣에서 외부경로 읽을 수 있게 server.xml에 Context추가
controller.action 일부 수정

페이지네이션 적용 준비
===================================================================================

10.28
===================================================================================
다국어처리를 위해 main/resource에 message패키지 생성
.properties로 끝나는 파일 생성
메뉴바커스텀태그 다국어 처리
.jsp로 끝나는 페이지 다국어 처리 오류 나서 .do로 변경 이후 컨트롤러에 메서드 생성
개인프로젝트에 카카오로그인 적용(DB 미구현)
파일입출력 중복 파일명 자바유틸에 UUID를 사용해서 파일명 앞에 랜덤값 추가
art.jsp페이지 뷰 수정
작품수정 및 삭제 구현
이메일 및 전화번호 DB 수정
회원가입 구현
회원정보 수정 및 탈되 구현
===================================================================================

10.29
===================================================================================
수정파일
main.css / ms_ko.properties / ms_en.properties / MemberController.java
menuBar.tag / editMember.jsp / editArt.jsp / login.jsp

메뉴바 환영합니다 부분 국제화 적용
art.jsp에이미지와 테이블 미디어쿼리 수정
회원정보수정에서 회원탈퇴부분 수정

===================================================================================

10.31
===================================================================================
수정파일
main.css / login.jsp / 

login.jsp에 구글/네이버 로그인 버튼 추가
회원가입css 수정

회원가입 중복검사 작업 진행중
===================================================================================

11.01
===================================================================================
수정된 파일
info.jsp / login.jsp / MemberController.java / pom.xml / 

추가된 파일
MailAuth.java / QamailSend.java / lib(jar파일) / 

SMTP를 위해 pom.xml에 dependency 추가
info에 구글맵API 및 SMTP(문의메일) 추가
메일인증을 위해 MailAuth 작성
메일발송을 위해 멤버컨트롤러에 메일발송 로직 작성
임시비밀번호를 위해 QamailSend작성
회원가입에 다음주소API 추가


회원가입 유효성검사 작업 예정
아이디 및 작가명 중복검사 작업 예정
임시비밀번호 발송 작업 예정
===================================================================================

11.01
===================================================================================
수정된 파일
login.jsp / MemberController.java / MemberDAO.java

아이디 및 작가명 중복검사를 위해 자바스크립트 추가
ajax를 위해 멤버컨트롤러 및 멤버DAO 수정
비밀번호 확인 자바스크립트 추가
===================================================================================

11.02
===================================================================================
수정된 파일
login.jsp / main.css / DB.sql / FavArtistVO.java / FavArtistDAO.java
MemberVO.java / MemberDAO.java / FavArtistController.java / editMember.jsp
menuBar.tag / MemberService.java / MemberServiceImpl.java / 

추가된 파일
login.js / SpringFavArtistDAO.java / SpringGalleryDAO.java / SpringMemberDAO.java

아이디 및 작가명 중복검사 ajax처리 완료
회원가입 유효성검사 작업 완료
해당 로직 login.js로 이동
텍스트 가운데 정렬을 위해 css 수정
일부 DB 칼럼 수정
수정된 테이블에 따라 VO 및 DAO 수정
회원정보수정페이지 수정
메뉴바에서 아코디언 메뉴안 부분 폰트스타일 변경
메뉴바 작가들 추가를 위해 멤버 selectAll 메서드 생성
메서드 생성에 따라 서비스와 서비스임플리에 추가
로그인 안 했을 경우 작가 안보이게 수정
컨트롤러에서 로그인시 멤버전체 검색후 세션에 저장하게 수정

스프링DAO 추가

관심작가추가 ajax로 구현 예정
===================================================================================

11.03
===================================================================================
수정된 파일
GalleryDAO.java / SpringGallery.java / GalleryService.java / GalleryServiceImpl.java
MemberDAO.java / SpringMemberDAO.java / MemberService.java / MemberServiceImpl.java
FavArtistDAO.java / SpringFavArtistDAO.java / FavArtistService.java / FavArtistServiceImpl.java
gallery-mapping.xml /  gallery.jsp / GalleryController.java / GalleryVO.java / sql-map-config.xml

추가된 파일
MybatisGalleryDAO.java / MybatisMemberDAO.java / MybatisFavArtistDAO.java
favArtist-mapping.xml / member-mapping.xml /

각DAO에 ArrayList를 List로 변경
스프링과 마이바티스 CUD부분 아웃풋 boolean타입으로 변경
마이바티스DAO 추가 작성
마이바티스DAO를 위해 .xml에 sql문 작성

더보기 버튼 구현중
===================================================================================
===================================================================================
===================================================================================
===================================================================================