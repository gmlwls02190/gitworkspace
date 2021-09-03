<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="fontSize" required="true"%>
<%@ attribute name="fontColor" required="true"%>

<p style="font-size:${fontSize}px; color:${fontColor};"><jsp:doBody/></p>