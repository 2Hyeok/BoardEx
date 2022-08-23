<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>

<h2>${page_content}</h2>

<table>
	<tr>
		<th>${str_num}</th>
		<td style="text-align:center">${number}</td>
		<th>${str_readcount}</th>
		<td style="text-align:center">${dto.readcount}</td>
	</tr>
	<tr>
		<th>${str_writer}</th>
		<td style="text-align:center">${dto.writer}</td>
		<th>${str_reg_date}</th>
		<td style="text-align:center">
		<fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
		</td>
	</tr>
	<tr>
		<th>${str_subject}</th>
		<td colspan="3">${dto.subject}</td>
	</tr>
	<tr>
		<th>${str_content}</th>
		<td colspan="3"> <pre>${dto.content}</pre> </td>
	</tr>
	<tr>
		<th colspan="4">
			<input class="inputbutton" type="button" value="${btn_mod}"
				onclick="location='modifyForm.do?num=${dto.num}&pageNum=${pageNum}'">
			<input class="inputbutton" type="button" value="${btn_del}"
				onclick="location='deleteForm.do?num=${dto.num}&pageNum=${pageNum}'">
			<input class="inputbutton" type="button" value="${btn_reply}"
				onclick="location='inputForm.do?num=${dto.num}&ref=${dto.ref}&re_step=${dto.re_step}&re_level=${dto.re_level}'">
			<input class="inputbutton" type="button" value="${btn_list}"
				onclick="location='list.do?pageNum=${pageNum}'">
	</tr>
</table>