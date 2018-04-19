
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homestay Social Network</title>
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
							style="width:300px; height:160px;">
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
					<div class="well">
						<c:forEach items="${listAccountByUsername}" var="acc">
							<h2>Account Profile</h2>
							<a class="btn btn-primary right"
								href="<c:url value="/account/edit/${acc.userName}"/>">Edit
								your profile</a>
							<hr />
							<form class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-sm-2">Full Name:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.fullName}"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="email">Username:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.userName}"/>
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Password:</label>
									<div class="col-sm-9">
										<input type="password" class="form-control" readonly value="${acc.passWord}"/> <a class="btn btn-danger btn-xs pull-right">Change password</a>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Email:</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" readonly value="${acc.emailAddress}"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Gender:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.gender}"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Phone Number:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.phoneNumber}"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Date Of Birth:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.dateOfBirth}"/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">Place Of Birth:</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" readonly value="${acc.placeOfBirth}"/>
									</div>
								</div>
							</form>
						</c:forEach>
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
