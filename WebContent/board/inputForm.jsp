<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="setting.jsp"%>
<link type="text/css" rel="stylesheet" href="${project}/board/style_board.css">
<script src="${project}/board/script.js"></script>
    
<h2>${page_write}</h2>


<form name="writeform" method="post" action="inputPro.do" onsubmit="return writecheck()">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="re_step" value="${re_step}">
	<input type="hidden" name="re_level" value="${re_level}">
	<table>
		<tr>
			<th colspan="2" style="text-align:right">
			<a href="list.do">${str_list}</a>&nbsp;&nbsp;&nbsp;
			</th>
		</tr>
		<tr>
			<th>${str_writer}</th>
			<td>
				<input class="input" type="text" name="writer" maxlength="30" autofocus>
			</td>	
		</tr>
		<tr>
			<th>${str_email}</th>
			<td>
				<input class="input" type="text" name="email" maxlength="40">
			</td>	
		</tr>
		<tr>
			<th>${str_subject}</th>
			<td>
				<input class="input" type="text" name="subject" maxlength="1000">
			</td>	
		</tr>
		<tr>
			<th>${str_content}</th>
			<td>
				<textarea name="content" rows="10" cols="40"></textarea>
			</td>	
		</tr>
		<tr>
			<th>${str_passwd}</th>
			<td>
				<input class="input" type="password" name="passwd" maxlength="20">
			</td>	
		</tr>
		<tr>
			<th colspan="2">
				<input class="inputbutton" type="submit" value="${btn_write}">
				<input class="inputbutton" type="reset" value="${btn_cancel}">
				<input class="inputbutton" type="button" value="${btn_list}"
					onclick="location='list.do'">
			</th>
		</tr>
	</table>
</form>