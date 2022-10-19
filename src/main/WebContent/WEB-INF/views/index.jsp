<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
<style>
button {
	padding: 14px 10%;
	border-radius: 12px;
	background-color: #008CBA;
	color: white;
	font-size: 20px;
}

button:hover {
	background-color: #4CAF50;
}
</style>
</head>
<body>
	<div class="intro" align="center">
		<h1>Employee Management System</h1>
		<div id="trainer">
			<h2>Trainer</h2>
			<a href="CreateTrainer"><button>Create</button></a> <a
				href="ViewTrainer"><button>View</button></a>
		</div>
		<div id="trainee">
			<h2>Trainee</h2>
			<a href="CreateTrainee"><button>Create</button></a> <a
				href="ViewTrainee"><button>View</button></a>
		</div>
	</div>
</body>
</html>