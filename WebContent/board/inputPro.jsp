<%@page import="board.BoardDBBean"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>
   
<h2>${page_write}</h2>

<c:if test="${result == 0}">
	<script type="text/javascript">
		<!--
        alert( inserterror );
        //-->
	</script>
	<meta http-equiv="refresh" content="0; url=list.do">
</c:if>
<c:if test="${result != 0}">
		<c:redirect url="list.do"/>
</c:if>