<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js">
	
</script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<br> <br> <br>
			<center>
				<h1 style="color: white">Booking Homestay Network</h1>
			</center>
			<div class="row">
				<div
					class="col-lg-6 col-md-6 col-sm-6 col-lg-offset-3 col-md-offset-3 col-sm-offset-3">
					<div id="registerForm">
						<c:if test="${not empty error}">
							<div class="errorblock alert alert-danger" role="alert" style="color:red;">Failed username or password</div>
						</c:if>
						<c:if test="${not empty logout}">
							<div class="alert alert-success" role="alert">You have logged out !!!</div>
						</c:if>
						<c:if test="${not empty regisSuccess}">
							<div class="alert alert-success" role="success">You have registered successfull !!!</div>
						</c:if>
						<form name='f' action="<c:url value='j_spring_security_check' />"
							method='POST'>
							<center>
								<h2>Login Form</h2>
							</center>
							<div class="form-group">
								<label for="inputName" class="control-label">Username</label> <input
									type="text" class="form-control" id="inputName"
									name='j_username' placeholder="Username" required>
							</div>
							<div class="form-group">
								<label for="pass" class="control-label">Password</label> <input
									type="password" class="form-control" id="pass"
									name='j_password' placeholder="Password" required>
							</div>
							<div class="form-group">
								<input type="checkbox"> Remember me?
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">Submit</button>
							</div>
						</form>
						<br>
						<hr>
						<center>
							<strong>Don't have an Account? <a
								href="<c:url value='/register' />">Register now!</a></strong>
						</center>
					</div>

				</div>
			</div>
			<div class="row" id="copyright">Copyright by Tuannk</div>
		</div>
	</div>
</body>
</html>