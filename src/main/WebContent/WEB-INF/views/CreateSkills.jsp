<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.ideas2it.model.Skills"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Skill</title>
</head>
<h1>Add Skill</h1>
<body style="margin-left: 38%">
	<form:form action="SaveSkill" modelAttribute="skill">
	    <input type="hidden" name="id" path="id" value="${id}">
	    <br>
	    <form:input type="hidden" path="skillId" name="skillId"/>
	    <table>
	    <tr>
                            <tr>
                                <th>Skill Name</th>
                                <th>Version</th>
                                <th>Last Used Year</th>
                                <th>Experience</th>
                            </tr>
                            <tr>
                                <td>
                                    <td><input type="text" name="skillName" path="skillName"/></td>
                                    <td><input type="text" name="skillVersion" path="skillVersion"/></td>
                                    <td><input type="text" name="lastUsedYear" path="lastusedYear"/></td>
                                    <td><input type="text" name="skillExperience" path="skillExperience"/></td>
                                </td>
                            </tr>
        				</tr>
        				</table>
		<button type="submit">Add Trainee</button>
	</form:form>
</body>

</html>
