<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript">
	$(function() {
		$('.navbar-toggle-sidebar').click(function() {
			$('.navbar-nav').toggleClass('slide-in');
			$('.side-body').toggleClass('body-slide-in');
			$('#search').removeClass('in').addClass('collapse').slideUp(200);
		});

		$('#search-trigger').click(function() {
			$('.navbar-nav').removeClass('slide-in');
			$('.side-body').removeClass('body-slide-in');
			$('.search-input').focus();
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button"
				class="navbar-toggle navbar-toggle-sidebar collapsed">MENU
			</button>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> Administrator </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="http://www.pingpong-labs.com" target="_blank">Visit
						Site</a></li>
				<li class="dropdown "><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">
						Account <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">SETTINGS</li>
						<li class=""><a href="#">Other Link</a></li>
						<li class=""><a href="#">Other Link</a></li>
						<li class=""><a href="#">Other Link</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<div class="row">
				<!-- uncomment code for absolute positioning tweek see top comment in css -->
				<div class="absolute-wrapper"></div>
				<!-- Menu -->
				<div class="side-menu">
					<nav class="navbar navbar-default" role="navigation"> <!-- Main Menu -->
					<div class="side-menu-container">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#"><span
									class="glyphicon glyphicon-dashboard"></span> User Management</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-plane"></span>
									Active Link</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cloud"></span>
									Link</a></li>

							<!-- Dropdown-->
							<li class="panel panel-default" id="dropdown"><a
								data-toggle="collapse" href="#dropdown-lvl1"> <span
									class="glyphicon glyphicon-user"></span> Sub Level <span
									class="caret"></span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-lvl1" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="#">Link</a></li>
											<li><a href="#">Link</a></li>
											<li><a href="#">Link</a></li>

											<!-- Dropdown level 2 -->
											<li class="panel panel-default" id="dropdown"><a
												data-toggle="collapse" href="#dropdown-lvl2"> <span
													class="glyphicon glyphicon-off"></span> Sub Level <span
													class="caret"></span>
											</a>
												<div id="dropdown-lvl2" class="panel-collapse collapse">
													<div class="panel-body">
														<ul class="nav navbar-nav">
															<li><a href="#">Link</a></li>
															<li><a href="#">Link</a></li>
															<li><a href="#">Link</a></li>
														</ul>
													</div>
												</div></li>
										</ul>
									</div>
								</div></li>

							<li><a href="#"><span class="glyphicon glyphicon-signal"></span>
									Link</a></li>

						</ul>
					</div>
					<!-- /.navbar-collapse --> </nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="col-md-12">

					<div class="panel panel-default panel-table">
						<div class="panel-heading">
							<div class="row">
								<div class="col col-xs-6">
									<h3 class="panel-title">Panel Heading</h3>
								</div>
								<div class="col col-xs-6 text-right">
									<button type="button" class="btn btn-sm btn-primary btn-create">Create
										New</button>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped table-bordered table-list">
								<thead>
									<tr>
										<th><em class="fa fa-cog"></em></th>
										<th>ID</th>
										<th>Name</th>
										<th>Fullname</th>
										<th>Email</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listAccount}" var="account"
										varStatus="status">
										<tr>

											<td align="center"><a class="btn btn-default"><em
													class="fa fa-pencil"></em></a> <a class="btn btn-danger"><em
													class="fa fa-trash"></em></a></td>
											<td>${status.count}</td>
											<td>${account.userName}</td>
											<td>${account.fullName}</td>
											<td>${account.emailAddress}</td>
											<td><c:choose>
													<c:when test="${account.enabled == 'true' }">
														<button class="btn btn-primary">Active</button>
													</c:when>
													<c:otherwise>
														<button class="btn btn-danger">Deactive</button>
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
	<footer class="pull-left footer">
		<p class="col-md-12">
		<hr class="divider">
		Copyright &COPY; 2018 QuocBuiNgoc</a>
		</p>
	</footer>
	</div>
</body>
</html>