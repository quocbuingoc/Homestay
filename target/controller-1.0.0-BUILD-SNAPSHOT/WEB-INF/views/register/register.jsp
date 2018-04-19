<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js">
	
</script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<br> <br> <br>
		<center>
			<h1 style="color: white">Booking Homestay Network</h1>
		</center>


		<div class="row">
			<div
				class="col-lg-6 col-md-6 col-sm-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
				<div id="registerForm">
					<c:url var="addAction" value="/doRegister"></c:url>
					<form:form action="${addAction}" method="POST"
						modelAttribute="newAccount">
						<center>
							<h2>Register</h2>
						</center>
						<div class="form-group">
							<label for="fullName" class="control-label">FullName:</label>
							<form:input type="text" class="form-control" path="fullName"
								id="fullName" placeholder="Your name" required="true" />
						</div>
						<div class="form-group">
							<label for="inputName" class="control-label">Username:</label>
							<form:input type="text" class="form-control" path="userName"
								id="inputName" placeholder="Username" />
							<form:errors path="userName" style="color:red"></form:errors>
						</div>
						<div class="form-group">
							<label for="pass" class="control-label">Password:</label>
							<form:input type="password" path="passWord" class="form-control"
								id="pass" placeholder="Password" />
							<form:errors path="passWord" style="color:red"></form:errors>
						</div>
						<div class="form-group">
							<label for="cfpass" class="control-label">Confirm
								password:</label>
							<form:input type="password" path="confirmPassword"
								class="form-control" id="cfpass" placeholder="Confirm Password" />
							<form:errors path="confirmPassword" style="color:red"></form:errors>
						</div>
						<div class="form-group">
							<label for="inputName" class="control-label">Email
								address:</label>
							<form:input type="email" path="emailAddress" class="form-control"
								id="inputName" placeholder="Email Address" />
						</div>
						<div class="form-group">
							<label for="phone" class="control-label">Phone Number:</label>
							<form:input type="text" path="phoneNumber" class="form-control"
								id="phone" placeholder="Your phone number" />
						</div>
						<div class="form-group">
							<label for="rule">Choose your permission:</label> <br>
							<label class="radio-inline"><form:radiobutton
									path="roles.roleId" name="optradio" value="2" required="true" />Guest</label> <label
								class="radio-inline"><form:radiobutton
									path="roles.roleId" name="optradio" value="1" equired="true" />Host</label>
						</div>
						<div class="form-group">
							<input type="checkbox" required> Agree with account?
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">Create</button>
						</div>
					</form:form>
					<br> <strong><a href="<c:url value='/login' />">Back
							to login page</a></strong>
				</div>

			</div>
		</div>
		<div class="row" id="copyright">Copyright by Tuannk</div>



	</div>
</body>
</html>