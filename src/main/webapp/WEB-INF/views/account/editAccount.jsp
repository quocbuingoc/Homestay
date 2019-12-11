
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Account</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link href="<c:url value="/resources/css/jquery-ui.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/style2.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	<script type="text/javascript">
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 50) {
				$('#back-to-top').fadeIn();
			} else {
				$('#back-to-top').fadeOut();
			}
		});
		// scroll body to 0px on click
		$('#back-to-top').click(function() {
			$('#back-to-top').tooltip('hide');
			$('body,html').animate({
				scrollTop : 0
			}, 800);
			return false;
		});

		$('#back-to-top').tooltip('show');

	});
</script>
</head>
<body>
	<div class="wrapper">
		<!-- Menu header -->
		<jsp:include page="../layout/_menuHeader.jsp" />
		<jsp:include page="../layout/_slide.jsp" />
		<div class="container" id="content">
			<div class="row">
				<div class="col-sm-2 col-md-2">
					<div id="avatar">
						<img class="img-responsive thumbnail"
							src="<c:url value="/resources/images/avatar/${imageUrl}"/>"
							width="300" height="300">
						<p class="text-center small">
							<a href="#">Change Your Photo</a>
						</p>
					</div>
					<hr />
					<ul id="sidebar" class="nav nav-stacked">
						<li><a href="#"><span
								class="glyphicon glyphicon-envelope"></span> Messages</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								Friends</a></li>

						<li><a href="#"><span class="glyphicon glyphicon-picture"></span>
								Photos</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-lock"></span>
								Setting</a></li>
						<li><a href='<c:url value="/j_spring_security_logout" />'><span
								class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
					</ul>
				</div>
				<div class="col-md-10">
					<div class="col-md-10 col-sm-10">
						<div class="well">
							<h2>Edit Your Profile</h2>
							<hr />
							<c:url var="updateAction"
								value="/account/update/${username}"></c:url>
							<form:form class="form-horizontal" action="${updateAction}"
								commandName="editProfile" enctype="multipart/form-data">
								<div class="form-group">
									<label class="control-label col-sm-2">Avatar:</label>
									<div class="col-sm-9">
										<img src="<c:url value="/resources/images/avatar/${imageUrl}" />" width="60"
											height="60" />
									</div>
								</div>
								<form:input path="accountId" type="hidden" />
								
								<form:input path="imageUrl" type="hidden" />
								<div class="form-group">
									<label class="control-label col-sm-2">Change Avatar:</label>
									<div class="col-sm-9">
										<input type="file" class="form-control" name="imageUpload"
											accept="image/*">
									</div>
								</div>
								<hr />
								<div class="form-group">
									<label class="control-label col-sm-2">Full Name:</label>
									<div class="col-sm-9">
										<form:input path="fullName" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Email:</label>
									<div class="col-sm-9">
										<form:input path="emailAddress" type="email"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Gender:</label>
									<div class="col-sm-9">
										<form:input path="gender" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Phone Number:</label>
									<div class="col-sm-9">
										<form:input path="phoneNumber" type="text"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Date Of Birth:</label>
									<div class="col-sm-9">
										<form:input path="dateOfBirth" type="text"
											class="form-control" id="datepicker" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Place Of Birth:</label>
									<div class="col-sm-9">
										<form:input path="placeOfBirth" type="text"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary col-sm-offset-2">Update</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a id="back-to-top" href="#"
			class="btn btn-primary btn-lg back-to-top" role="button"><span
			class="glyphicon glyphicon-chevron-up"></span></a>
	</div>
</body>
</html>
