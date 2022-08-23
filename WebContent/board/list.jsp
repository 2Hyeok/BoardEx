<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>


<h2>${page_list} ( ${str_count} : ${count} )</h2>

<table>
	<tr>
		<td colspan="6" style="text-align:right">
			<a href="inputForm.do">${str_write}</a>&nbsp;&nbsp;&nbsp;
	</tr>
	<tr>
		<th style="width:7%">${str_num}</th>
		<th style="width:35%">${str_subject}</th>
		<th style="width:10%">${str_writer}</th>
		<th style="width:15%">${str_reg_date}</th>
		<th style="width:7%">${str_readcount}</th>
		<th style="width:10%">${str_ip}</th>
	</tr>
	<c:if test="${count == 0}">
			<tr>
				<td colspan="6" style="text-align:center">${msg_list}</td>
			</tr>
	</c:if>
	<c:if test="${count != 0}">
		<c:set var="number" value="${number}"/>
		<c:forEach var="dto" items="${dtos}">
				<tr>
					<td style="text-align:center">
						${number}
						<c:set var="number" value="${number-1}"/>
					</td>
					<td>
						<c:set var="wid" value="${(dto.re_level-1) * 10}"/>
							<c:if test="${dto.re_level gt 1}">
								<img src="${project}/images/level.gif" width="${wid}" height="15">
							</c:if>
							<c:if test="${dto.re_level gt 0}">
								<img src="${project}/images/re.gif" width="15" height="15">
							</c:if>
							<c:if test="${dto.readcount == -1}">
								${dto.subject}
							</c:if>
							<c:if test="${dto.readcount != -1}">
								<a href="content.do?num=${dto.num}&pageNum=${pageNum}&number=${number+1}">
								${dto.subject}
								</a>
							</c:if>
					</td>
					<td style="text-align:center">
						${dto.writer}
					</td>
					<td style="text-align:center">
						<fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm"/>
					</td>
					<td style="text-align:center">
					<c:if test="${dto.readcount == -1}">
							&nbsp;
					</c:if>
					<c:if test="${dto.readcount != -1}">
							${dto.readcount}
					</c:if>
					</td>
					<td style="text-align:center">
						${dto.ip}
					</td>
				</tr>
		</c:forEach>
	</c:if>
</table>
<br>
<center>
<c:if test="${count gt 0}">
	<c:if test="${startPage gt pageBlock}">
			<a href="list.do?pageNum=${startPage - pageBlock}">[◀]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<c:if test="${i == currentPage}">
			<b>[${i}]</b>
		</c:if>
		<c:if test="${i != currentPage}">
			<a href="list.do?pageNum=${i}">[${i}]</a>
		</c:if>
	</c:forEach>
	<c:if test="${pageCount gt endPage}">
		<a href="list.do?pageNum=${startPage + pageBlock}">[▶]</a>
	</c:if>
</c:if>
</center>