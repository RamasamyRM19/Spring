<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Trainer</title>
<style>
body{
font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
background-color: #ccffff;
}
#submit {
margin-top: 20px;
    padding: 5px 25px;
}
h1 {
text-decoration: underline;
    text-decoration-style: double;
    }
</style>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
        <form:form modelAttribute="trainerDto" action="updateTrainer" method="post">
        <form:hidden path="id" />
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><form:input type="text" path="firstName" name="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input type="text" name="lastName" path="lastName" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><form:input type="text" name="designation" path="designation" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><form:input type="text" name="department" path="department" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><form:input type="number" name="phoneNumber" path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><form:input type="email" name="emailId" path="emailId" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><form:input type="date" name="dateOfBirth" path="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Previous Experience</td>
					<td><form:input type="number" name="previousExperience" path="previousExperience" /></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><form:input type="date" name="dateOfJoining" path="dateOfJoining" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><form:input type="number" name="salary" path="salary" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /> <a href="ViewTrainer"> </a><input type="reset">
		</form:form>
	</div>
</body>
</html>
