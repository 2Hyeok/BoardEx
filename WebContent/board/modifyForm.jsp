<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>

<h2>${page_modify}</h2>

<form name="passwdform" method="post" action="modifyView.do" onsubmit="return passwdcheck()">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="pageNum" value="${pageNum}">
	<table>
		<tr>
			<th colspan="2">${msg_passwd}</th>
		</tr>
		<tr>
			<th>${str_passwd}</th>
			<td> <input class="input" type="password" name="passwd" maxlength="20" autofocus></td>
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_mod}">
				<input class="inputbutton" type="button" value="${btn_mod_cancel}"
					onclick="location='list.do?pageNum=${pageNum}'">
			</th>
		</tr>
	</table>
</form>