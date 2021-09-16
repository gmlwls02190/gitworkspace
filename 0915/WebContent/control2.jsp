<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.user.*"%>
<jsp:useBean id="mDAO" class="model.msg.MessageDAO" />
<jsp:useBean id="rDAO" class="model.msg.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.user.UserDAO" />
<jsp:useBean id="mVO" class="model.msg.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<jsp:useBean id="rVO" class="model.msg.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<jsp:setProperty property="*" name="uVO"/>

<%
	String action=request.getParameter("action");

int cPage; //현재 페이지를 의미
try {
    cPage = Integer.parseInt(request.getParameter("cPage"));
}catch (NumberFormatException e) {
    cPage = 1;
}
int numPerPage;    //페이지당 자료수
try {
    numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
}catch (NumberFormatException e) {
    numPerPage = 1;
}

//페이지수 만큼 데이터를 불러옴
ArrayList<MessageVO> msgLists = mDAO.selectTest(cPage, numPerPage);

//페이지 구성해보기
//전체자료수를 확인
int totalList = mDAO.selectTestCount(null);
//전체페이수
int totalPage = (int)Math.ceil((double)totalList/numPerPage);
//페이지바 html코드 누적변수
String pageBar="";
//페이지바 길이
int pageBarSize =5;
int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
int pageEnd = pageNo+pageBarSize-1;
//페이지바를 구성
if(pageNo==1) {
  pageBar +="<span>[이전]&nbsp;</span>";
}else {
  pageBar += "<a href='"+request.getContextPath()+
          "/control2.jsp?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]&nbsp;</a>";
}
//선택페이지 만들기
while(!(pageNo>pageEnd || pageNo>totalPage))
{
  if(cPage==pageNo) {
      pageBar += "<span class='cPage'>"+pageNo+"</span>";
  }else {
      pageBar += "<a href='"+request.getContextPath()+
              "/control2.jsp?cPage="+(pageNo)+"&numPerPage="+numPerPage+"'>"+"&nbsp;"+pageNo+"&nbsp;"+"</a>";
  }
  pageNo++;
}
//[다음] 구현
if(pageNo>totalPage) 
{
  pageBar += "<span>&nbsp;[다음]</span>";
}else {
  pageBar +="<a href='"+request.getContextPath()+
          "/control2.jsp?cPage="+pageNo+"&numPerPage="+numPerPage+"'>&nbsp;[다음]</a>";
}
request.setAttribute("list", msgLists);
request.setAttribute("cPage", cPage);
request.setAttribute("numPerPage", numPerPage);
request.setAttribute("pageBar", pageBar);
request.getRequestDispatcher("/test.jsp").forward(request, response);

/* 	if(action.equals("test")){
		pageContext.forward("test.jsp");
	} */
%>