<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skills"%>
<%@page isELIgnored="false"%>
<%
    String action = (String) request.getAttribute("action");
    String flag = (String) request.getAttribute("action");
    Trainee trainee = (Trainee) request.getAttribute("trainee");
    Skills skills = (Skills) request.getAttribute("skills");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Trainee</title>
</head>
<body align="center">
	<div align="center">
		<h1>Employee Register Form</h1>
		    <form:form modelAttribute="trainee" action="insertTrainee?action=${action}" method="post">
            <form:form modelAttribute="trainee" flag="insertTrainee?flag=${action}" method="post">
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
					<td>Passed Out year</td>
					<td><form:input type="number" min="1900" max="2099" step="1"
						value="2016" path = "passedOutYear" name="passedOutYear" /></td>
				</tr>
				<tr>
					<th>Skill Name</th>
					<th>Version</th>
					<th>Last Used Year</th>
					<th>Experience</th>
				</tr>
				<tr>
				<td>
                    <td><form:input type="text" name="skillName" path = "skillName" /></td>
                    <td><form:input type="text" name="version" path = "skillVersion" /></td>
                    <td><form:input type="number" name="lastUsedYear" path = "lastUsedYear" /></td>
                    <td><form:input type="number" name="experience" path = "skillExperience" /></td>
                </td>
				</tr>
			</table>
			<input type="submit" id = "submit" value="Submit" />
			<input type="reset">
			<input action="/" type="button" onclick="history.go(-1);" value="Back"/>
		</form:form>
        </form:form>
	</div>
</body>
</html>