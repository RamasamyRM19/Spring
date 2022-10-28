<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page import="com.ideas2it.dto.TrainerDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Trainer</title>
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
  border-color: #d3d3cf;
  border-radius: 5px;
}
#back {
    margin-top: 20px;
    padding: 5px 25px;
}
button, #back {
      cursor: pointer;
      display: inline-block;
      padding: 7px 20px;
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
	<input type="hidden" name="flag" value="viewTrainer">
	<div align="center">
		<table>
		    <h2>List of Trainers</h2>
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
				<th>Salary</th>
				<th colspan="2">Update / Delete</th>
			</tr>

			<%
			List<TrainerDto> trainers = (List) request.getAttribute("trainersDto");
			for (TrainerDto trainer : trainers) {
			%>
			<tr>
				<td><%=trainer.getId()%></td>
				<td><%=trainer.getFirstName()%></td>
				<td><%=trainer.getLastName()%></td>
				<td><%=trainer.getDesignation()%></td>
				<td><%=trainer.getDepartment()%></td>
				<td><%=trainer.getPhoneNumber()%></td>
				<td><%=trainer.getEmailId()%></td>
				<td><%=trainer.getDateOfBirth()%></td>
				<td><%=trainer.getPreviousExperience()%></td>
				<td><%=trainer.getDateOfJoining()%></td>
				<td><%=trainer.getSalary()%></td>
				<td><a
					href="getTrainerById?id=<%= trainer.getId()%>">
						<button class="update">Update</button>
				</a></td>
				<td><a
					href="deleteTrainer?id=<%= trainer.getId()%>">
						<button class="delete">Delete</button>
				</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<input action="/" id = "back" type="button" onclick="history.go(-1);" value="Back"/>
		<a href = "CreateTrainer"><button id = "back">Add New Trainer</button></a>
	</div>
</body>
</html>