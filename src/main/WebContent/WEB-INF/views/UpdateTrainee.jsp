<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skills"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Trainee</title>
</head>
<body>
	<div align="center">
		<%
		Trainee trainee = (Trainee) request.getAttribute("trainee");
		Integer employeeId = Integer.parseInt(request.getParameter("id"));
		String firstName = trainee.getFirstName();
		String lastName = trainee.getLastName();
		String designation = trainee.getDesignation();
		String department = trainee.getDepartment();
		String phoneNumber = String.valueOf(trainee.getPhoneNumber());
		String emailId = trainee.getEmailId();
		String dateOfBirth = String.valueOf(trainee.getDateOfBirth());
		String previousExperience = String.valueOf(trainee.getPreviousExperience());
		String dateOfJoining = String.valueOf(trainee.getDateOfJoining());
		String passedOutYear = String.valueOf(trainee.getPassedOutYear());
		session.setAttribute("trainee", trainee);
		%>
		<h1>Employee Register Form</h1>
		<form:form modelAttribute="trainee" action="insertTrainee?action=${action}" method="post">
        <form:form modelAttribute="trainee" flag="updateTrainee?flag=${action}" method="post">
        <form:hidden path="id" />
			<table style="with: 80%">
				<tr>
                	<td>First Name</td>
                					<td><input type="text" path="firstName" name="firstName"
                						value="<%=firstName%>" /></td>
                				</tr>
                				<tr>
                					<td>Last Name</td>
                					<td><input type="text" name="lastName" path="lastName" value="<%=lastName%>" /></td>
                				</tr>
                				<tr>
                					<td>Designation</td>
                					<td><input type="text" name="designation" path="designation"
                						value="<%=designation%>" /></td>
                				</tr>
                				<tr>
                					<td>Department</td>
                					<td><input type="text" name="department" path="department"
                						value="<%=department%>" /></td>
                				</tr>
                				<tr>
                					<td>Phone Number</td>
                					<td><input type="number" name="phoneNumber" path="phoneNumber"
                						value="<%=phoneNumber%>" /></td>
                				</tr>
                				<tr>
                					<td>Email Id</td>
                					<td><input type="email" name="emailId" path="emailId"
                					value="<%=emailId%>" /></td>
                				</tr>
                				<tr>
                					<td>Date Of Birth</td>
                					<td><input type="date" name="dateOfBirth" path="dateOfBirth"
                						value="<%=dateOfBirth%>" /></td>
                				</tr>
                				<tr>
                					<td>Previous Experience</td>
                					<td><input type="number" name="previousExperience" path="previousExperience"
                						value="<%=previousExperience%>" /></td>
                				</tr>
                				<tr>
                					<td>Date Of Joining</td>
                					<td><input type="date" name="dateOfJoining" path="dateOfJoining"
                						value="<%=dateOfJoining%>" /></td>
                				</tr>
				<tr>
					<td>Passed Out year</td>
					<td><input type="number" min="1900" max="2099" step="1"
						value="2016" path = "passedOutYear" name="passedOutYear" value="<%=passedOutYear%>" /></td>
				</tr>
				<tr>
				<tr>
					<th>Skill Name</th>
					<th>Version</th>
					<th>Last Used Year</th>
					<th>Experience</th>
				</tr>
				<tr>
					<%
					for (Skills skill : trainee.getSkills()) { %>
					<input type="hidden" name="skillId" path = "skillId" value="<%=skill.getSkillId()%>">
					<td><input type="text" name="skillName" path = "skillName"
						value="<%=skill.getSkillName()%>" /></td>
					<td><input type="text" name="version" path = "version" value="<%=skill.getSkillVersion()%>" /></td>
					<td><input type="number" name="lastUsedYear" path = "lastUsedYear"
						value="<%=skill.getLastUsedYear()%>" /></td>
					<td><input type="number" name="experience" path = "experience"
						value="<%=skill.getSkillExperience()%>" /></td>
					<%
					}
					%>
				</tr>
			</table>
			<input type="hidden" name="id" value="<%=employeeId%>">
			<input type="hidden" name="traineeId" value="<%=employeeId%>">
			<input type="submit" value="Submit" /> <a href="ViewTrainee"> </a>
			<input type="reset">
		</form>
	</div>
</body>
</html>
