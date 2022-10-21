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
		<h1>Employee Register Form</h1>
		<form method="POST" action="/EmployeeSpring/UpdateTrainee">
                <input type="hidden" path="id">
			<table style="with: 80%">
				<tr>
                	<td>First Name</td>
                					<td><input type="text" path="firstName" name="firstName"
                						/></td>
                				</tr>
                				<tr>
                					<td>Last Name</td>
                					<td><input type="text" name="lastName" path="lastName"  /></td>
                				</tr>
                				<tr>
                					<td>Designation</td>
                					<td><input type="text" name="designation" path="designation"
                						/></td>
                				</tr>
                				<tr>
                					<td>Department</td>
                					<td><input type="text" name="department" path="department"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Phone Number</td>
                					<td><input type="number" name="phoneNumber" path="phoneNumber"
                						/></td>
                				</tr>
                				<tr>
                					<td>Email Id</td>
                					<td><input type="email" name="emailId" path="emailId"
                					/></td>
                				</tr>
                				<tr>
                					<td>Date Of Birth</td>
                					<td><input type="date" name="dateOfBirth" path="dateOfBirth"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Previous Experience</td>
                					<td><input type="number" name="previousExperience" path="previousExperience"
                						 /></td>
                				</tr>
                				<tr>
                					<td>Date Of Joining</td>
                					<td><input type="date" name="dateOfJoining" path="dateOfJoining"
                						/></td>
                				</tr>
				<tr>
					<td>Passed Out year</td>
					<td><input type="number" min="1900" max="2099" step="1"
						path = "passedOutYear" name="passedOutYear" /></td>
				</tr>
				<tr>
				<tr>
					<th>Skill Name</th>
					<th>Version</th>
					<th>Last Used Year</th>
					<th>Experience</th>
				</tr>
				<tr>
					<input type="hidden" name="skillId" path = "skillId" />
					<td><input type="text" name="skillName" path = "skillName" /></td>
					<td><input type="text" name="version" path = "version" /></td>
					<td><input type="number" name="lastUsedYear" path = "lastUsedYear" /></td>
					<td><input type="number" name="experience" path = "experience" /></td>
				</tr>
			</table>
			<input type="hidden" name="id">
			<input type="hidden" name="traineeId" value="id">
			<input type="submit" value="Submit" /> <a href="ViewTrainee"> </a>
			<input type="reset">
		</form>
	</div>
</body>
</html>