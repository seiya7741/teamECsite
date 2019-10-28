<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/createDestination.css">
<link rel="stylesheet" type="text/css" href="./css/home.css">
<title>宛先登録ページ</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">

		<h1>宛先情報入力画面</h1>

		<s:if
			test="familyNameErrorMessageList!= null && familyNameErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="familyNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="firstNameErrorMessageList!=null && firstNameErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="firstNameErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="familyNameFuriganaErrorMessageList!=null && familyNameFuriganaErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="familyNameFuriganaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="firstNameFuriganaErrorMessageList!=null && firstNameFuriganaErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="firstNameFuriganaErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if
			test="addressErrorMessageList!=null && addressErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="addressErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="phoneNumberErrorMessageList!=null && phoneNumberErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="phoneNumberErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if test="emailErrorMessageList!=null && emailErrorMessageList.size()>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="emailErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:form action="CreateDestinationConfirmAction">
			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="姓" /></th>
					<td><s:textfield name="familyName"
							value="%{#session.familyName}" placeholder="姓" class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名" /></th>
					<td><s:textfield name="firstName"
							value="%{#session.firstName}" placeholder="名" class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="姓ふりがな" /></th>
					<td><s:textfield name="familyNameFurigana"
							value="%{#session.familyNameFurigana}" placeholder="姓ふりがな"
							class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="名ふりがな" /></th>
					<td><s:textfield name="firstNameFurigana"
							value="%{#session.firstNameFurigana}" placeholder="名ふりがな"
							class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="住所" /></th>
					<td><s:textfield name="address" value="%{#session.address}"
							placeholder="住所" class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="電話番号" /></th>
					<td><s:textfield name="phoneNumber"
							value="%{#session.phoneNumber}" placeholder="電話番号" class="txt" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="メールアドレス" /></th>
					<td><s:textfield name="email" value="%{#session.email}"
							placeholder="メールアドレス" class="txt" /></td>
				</tr>
			</table>
			<div class="c_submit_btn_box">
				<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>
</body>
</html>