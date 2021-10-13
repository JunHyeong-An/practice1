<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form id="login_form" method="POST">
	<h1>로그인</h1>
	<table>
		<tr>
			<td>ID</td>
			<td><input name="id"></td>
			<td rowspan="2"><button id="login_btn">로그인</button></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input name="password" type="password"></td>
		</tr>
	</table>
	<div>
		<a href=""><span>아이디찾기</span></a>
		<a href=""><span>비밀번호찾기</span></a>
		<a href=""><span>회원가입</span></a>
	</div>
</form>

<%@ include file="../footer.jsp"%>