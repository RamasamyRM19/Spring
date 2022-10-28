<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.dto.TraineeDto"%>
<%@page import="com.ideas2it.dto.SkillDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Trainee</title>
<style>
body{
font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
background-color: #ccffff;
}
table{
border-style: solid;
}
tr, th, td {
  border-style: inset;
}
#back {
    margin-top: 20px;
    padding: 5px 25px;
}
button, #back {
      cursor: pointer;
      display: inline-block;
      padding: 13px 20px;
      text-align: center;
      text-decoration: none;
      transition: all 250ms;
      border-style: inset;
      border-color: #d3d3cf;
      border-radius: 5px;
      font-size: 16px;
      user-select: none;
      -webkit-user-select: none;
      touch-action: manipulation;
    }
    .update:hover {
                    background-color: green;
                    box-shadow: #039C18 0 -25px 18px -14px inset,#039C18 0 1px 2px,#039C18 0 2px 4px;
                    color: white;
                }
                .delete:hover {
                    background-color: red;
                    box-shadow: #F46767 0 -25px 18px -14px inset,#F46767 0 1px 2px, #F46767 0 2px 4px;
                    color: white;
                }
    #back:hover {
            background-color: #3C87FA;
            box-shadow: #3C87FA 0 -25px 18px -14px inset,#3C87FA 0 1px 2px, #3C87FA 0 2px 4px;
            color: white;
            }
            h2 {
            text-decoration: underline;
                text-decoration-style: double;
                }
</style>
</head>
<body>
    <input type="hidden" name="flag" value="viewTrainee">
	<div align="center">
		<table>
			<h2>List of Trainees</h2>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Designation</th>
				<th>Department</th>
				<th>Phone Number</th>
				<th>Email Id</th>
				<th>Date Of Birth</th>
				<th>Previous Experience</th>
				<th>Date Of Joining</th>
				<th>Passed Out Year</th>
				<th>Skill</th>
				<th>Skill Version</th>
				<th>Last Used Year</th>
				<th>Skill Experience</th>
				<th colspan="2">Update / Delete</th>
			</tr>

			<%
			List<TraineeDto> trainees = (List) request.getAttribute("traineesDto");
            for (TraineeDto trainee : trainees) {
			%>
			<tr>
				<td><%=trainee.getId()%></td>
				<td><%=trainee.getFirstName()%></td>
				<td><%=trainee.getLastName()%></td>
				<td><%=trainee.getDesignation()%></td>
				<td><%=trainee.getDepartment()%></td>
				<td><%=trainee.getPhoneNumber()%></td>
				<td><%=trainee.getEmailId()%></td>
				<td><%=trainee.getDateOfBirth()%></td>
				<td><%=trainee.getPreviousExperience()%></td>
				<td><%=trainee.getDateOfJoining()%></td>
				<td><%=trainee.getPassedOutYear()%></td>
				<%for (SkillDto skill : trainee.getSkillsDto()) { %>
				<td><%=skill.getSkillName()%></td>
				<td><%=skill.getSkillVersion()%></td>
				<td><%=skill.getLastUsedYear()%></td>
				<td><%=skill.getSkillExperience()%></td>
				<% } %>
				<td><a href="getTraineeById?id=<%= trainee.getId()%>">
                						<button class="update">Update</button>
                				</a></td>
                				<td><a
                					href="deleteTrainee?id=<%= trainee.getId()%>">
                						<button class="delete">Delete</button>
                				</a></td>
			</tr>
			<% } %>
		</table>
		<input action="/" id = "back" type="button" onclick="history.go(-1);" value="Back"/>
		<a href = "CreateTrainee"><button id = "back">Add New Trainee</button></a>
	</div>
</body>
</html>