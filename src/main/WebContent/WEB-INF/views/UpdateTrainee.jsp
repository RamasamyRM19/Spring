<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skills"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Trainee</title>
<style>
body{
font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
background-color: #ccffff;
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
		<form:form modelAttribute="traineeDto" action="updateTrainee" method="post">
			<table style="with: 80%">
				<tr>
				    <form:input type="hidden" name="id" path="id" />
                	<td>First Name</td>
                					<td><form:input type="text" path="firstName" name="firstName"
                						/></td>
                				</tr>
                				<tr>
                					<td>Last Name</td>
                					<td><form:input type="text" name="lastName" path="lastName"  /></td>
                				</tr>
                				<tr>
                					<td>Designation</td>
                					<td><form:input type="text" name="designation" path="designation"
                						/></td>
                				</tr>
                				<tr>
                					<td>Department</td>
                					<td><form:input type="text" name="department" path="department"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Phone Number</td>
                					<td><form:input type="number" name="phoneNumber" path="phoneNumber"
                						/></td>
                				</tr>
                				<tr>
                					<td>Email Id</td>
                					<td><form:input type="email" name="emailId" path="emailId"
                					/></td>
                				</tr>
                				<tr>
                					<td>Date Of Birth</td>
                					<td><form:input type="date" name="dateOfBirth" path="dateOfBirth"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Previous Experience</td>
                					<td><form:input type="number" name="previousExperience" path="previousExperience"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Date Of Joining</td>
                					<td><form:input type="date" name="dateOfJoining" path="dateOfJoining"
                						/></td>
                				</tr>
				<tr>
					<td>Passed Out year</td>
					<td><form:input type="number" min="1900" max="2099" step="1"
						path = "passedOutYear" name="passedOutYear" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /> <a href="ViewTrainee"> </a>
			<input type="reset">
		</form:form>
	</div>
</body>
</html>