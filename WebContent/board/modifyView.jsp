<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>

<h2>${page_modify}</h2>

<c:if test="${result == 0}">

		<script type="text/javascript">
		<!--
		erroralert(passwderror);
		//-->
		</script>
</c:if>
<c:if test="${result !=0}">
		<form name="modifyform" method="post" action="modifyPro.do" onsubmit="return modifycheck()">
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="pageNum" value="${pageNum}">
			<table>
				<tr>
					<th colspan="2">
						${msg_modify}
					</th>
				</tr>
				<tr>
					<th>${str_writer}</th>
					<td>&nbsp;${dto.writer}
					</td>
				</tr>
				<tr>
					<th>${str_email}</th>
					<td>
						<c:if test="${dto.email == null}">
							<input class="input" type="text" name="email" maxlength="30">
						</c:if>
						<c:if test="${dto.email != null}">
							<input class="input" type="text" name="email" maxlength="30" value="${dto.email}">
						</c:if>
					</td>	
				</tr>
				<tr>
				<th>${str_subject}</th>
					<td>
						<input class="input" type="text" name="subject" maxlength="30" value="${dto.subject}">
					</td>	
				</tr>
				<tr>
					<th>${str_content}</th>
					<td>
						<textarea name="content" rows="10" cols="40" >${dto.content}</textarea>
					</td>	
				</tr>
				<tr>
					<th>${str_passwd}</th>
					<td>
						<input class="input" type="password" name="passwd" maxlength="20" value="${dto.passwd}">
					</td>	
				</tr>
				<tr>
					<th colspan="2">
						<input class="inputbutton" type="submit" value="${btn_write}">
						<input class="inputbutton" type="reset" value="${btn_cancel}">
						<input class="inputbutton" type="button" value="${btn_mod_cancel}"
							onclick="location='list.do?pageNum=${pageNum}'">
					</th>
				</tr>
			</table>
		</form>
</c:if>