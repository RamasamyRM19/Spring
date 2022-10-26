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
<style>
body{
font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
background-color: #ccffff;
}
#submit, #reset, #back {
margin-top: 20px;
    padding: 5px 25px;
    font-size: 15px;
}
td {
width : 50%;
}
#dob {
width: 97%;
    text-align: center;
    font-size: 14px;
}
#poy {
width: 95%;
text-align: center;
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
		    <form:form modelAttribute="trainee" action="insertTrainee?action=${action}" method="post">
            <form:hidden path="id" />
            <table style="with: 80%">
				<tr>
                    <td>First Name</td>
                	<td><form:input type="text" path="firstName" name="firstName"
                	    required="required"/></td>
                </tr>
                <tr>
                	<td>Last Name</td>
                	<td><form:input type="text" path="lastName" name="lastName"
                	    required="required"/></td>
                </tr>
                <tr>
                	<td>Designation</td>
                	<td><form:input type="text" path="designation" name="designation"
                	    required="required"/></td>
                </tr>
                <tr>
                	<td>Department</td>
                	<td><form:input type="text" path="department" name="department"
                	    required="required"/></td>
                </tr>
                <tr>
                	<td>Phone Number</td>
                	<td><form:input type="number" path="phoneNumber" name="phoneNumber"
                	     placeholder="9876543210" required="required"/></td>
                </tr>
                <tr>
                	<td>Email Id</td>
                	<td><form:input type="email" path="emailId" name="emailId"
                	     placeholder="***@gmail.com" required="required" /></td>
                </tr>
                <tr>
                	<td>Date Of Birth</td>
                	<td><form:input type="date" path="dateOfBirth" name="dateOfBirth"
                	    required="required" id = "dob"/></td>
                </tr>
                <tr>
                	<td>Previous Experience</td>
                	<td><form:input type="number" step="any" path="previousExperience" name="previousExperience"
                	     placeholder="*.** / **.**" required="required"/></td>
                </tr>
                <tr>
                	<td>Date Of Joining</td>
                	<td><form:input type="date" path="dateOfJoining" name="dateOfJoining" required="required"
                	     id = "dob" /></td>
                </tr>
				<tr>
					<td>Passed Out year</td>
					<td><form:input type="number" min="1900" max="2099" step="1"
						value="2016" path = "passedOutYear" name="passedOutYear"
						required="required" id = "poy"/></td>
				</tr>
			</table>
			<input type="submit" id = "submit" value="Proceed further to add skills" />
			<input type="reset" id = "reset">
			<input action="/" type="button" id = "back" onclick="history.go(-1);" value="Back"/>
		</form:form>
	</div>
</body>
</html>