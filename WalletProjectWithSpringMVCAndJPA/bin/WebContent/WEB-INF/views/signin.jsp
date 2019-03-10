<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up Page</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Welcome to Wallet Application</h1>
	<a href="">Home</a>
	<div align="center">
		<h2>Please sign up here</h2>
	</div>
	<table>
		<form:form action="registerCustomer" method="post"
			modelAttribute="customer">
			<tr>
				<td>Name :</td>
				<td><form:input path="customerName" size="30" /></td>
				<td><form:errors path="customerName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><form:input path="mobileNumber" size="30" /></td>
				<td><form:errors path="mobileNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Balance :</td>
				<td><form:input path="wallet.balance" size="30" /></td>
				<td><form:errors path="wallet.balance" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>