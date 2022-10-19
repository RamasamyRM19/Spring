<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page isELIgnored="false"%>
<%
    String action = (String) request.getAttribute("action");
    String flag = (String) request.getAttribute("action");
	Trainer trainer = (Trainer) request.getAttribute("trainer");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Trainer</title>
</head>
<body align="center">
	<div align="center">
		<h1>Employee Register Form</h1>
        	<form:form modelAttribute="trainer" action="insertTrainer?action=${action}" method="post">
        	<form:form modelAttribute="trainer" flag="insertTrainer?flag=${action}" method="post">
            <form:hidden path="id" />
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><form:input type="text" path="firstName" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input type="text" path="lastName" name="lastName" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><form:input type="text" path="designation" name="designation" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><form:input type="text" path="department" name="department" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><form:input type="number" path="phoneNumber" name="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><form:input type="email" path="emailId" name="emailId" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><form:input type="date" path="dateOfBirth" name="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Previous Experience</td>
					<td><form:input type="number" path="previousExperience" name="previousExperience" /></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><form:input type="date" path="dateOfJoining" name="dateOfJoining" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><form:input type="number" path="salary" name="salary" /></td>
				</tr>
			</table>
			<input type="submit" id = "submit" value="Submit" />
			<input type="reset">
			<input action="/" type="button" onclick="history.go(-1);" value="Back" />
		</form:form>
		</form:form>
	</div>
</body>
</html>