<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Skills"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Skill</title>
<style>
body{
font-family: CerebriSans-Regular,-apple-system,system-ui,Roboto,sans-serif;
background-color: #ccffff;
}
#submit {
margin-top: 20px;
    padding: 5px 25px;
}
</style>
</head>
<h1>Add Skill</h1>
<body align="center">
	<form:form action="SaveSkill" modelAttribute="skillDto">
	    <input type="hidden" name="id" path="id" value="${id}"/>
	    <br>
	    <form:input type="hidden" path="skillId" name="skillId" />
	    <table align="center">
	        <tr>
                <tr>
                    <th>Skill Name</th>
                    <th>Version</th>
                    <th>Last Used Year</th>
                    <th>Experience</th>
                </tr>
                <tr>
                    <td><input type="text" name="skillName" path="skillName" placeholder="Java" /></td>
                    <td><input type="text" name="skillVersion" path="skillVersion" placeholder="12" /></td>
                    <td><input type="number" name="lastUsedYear" min="1900" max="2099" step="1"
                        value="2016" path="lastUsedYear"/></td>
                    <td><input type="number" name="skillExperience" step="any" path="skillExperience"
                        placeholder="0.5"/></td>
                </tr>
            </tr>
        </table>
		<button type="submit" id="submit">Add Trainee</button>
	</form:form>
</body>

</html>
