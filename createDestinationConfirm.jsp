<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/createDestination.css">
<link rel="stylesheet" type="text/css" href="./css/home.css">
<title>宛先情報入力画面</title>
</head>
<body>
	<script src="./js/arizona.js"></script>
	<jsp:include page="header.jsp" />
	<div id="contents">
	<div class="box">
		<h1>宛先情報入力確認画面</h1>
	</div>
		<s:form id="createDestinationForm">
			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="姓" /></th>
					<td><s:property value="familyName" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名" /></th>
					<td><s:property value="firstName" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="姓ふりがな" /></th>
					<td><s:property value="familyNameFurigana" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名ふりがな" /></th>
					<td><s:property value="firstNameFurigana" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="住所" /></th>
					<td><s:property value="address" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="電話番号" /></th>
					<td><s:property value="phoneNumber" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="メールアドレス" /></th>
					<td><s:property value="email" /></td>
				</tr>
			</table>
			<div class="c_submit_btn_box">
				<s:submit value="登録" class="submit_btn"
					onclick="goCreateDestinationCompleteAction()" />
			</div>
			<div class="c_submit_btn_box">
				<s:submit value="戻る" class="submit_btn"
					onclick="goCreateDestinationAction()" />
			</div>
			<s:hidden id="backFlag" name="backFlag" value="" />
		</s:form>
	</div>
</body>
</html>