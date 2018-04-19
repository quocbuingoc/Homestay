<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navbar">
	<nav class="navbar navbar-default navbar-static-top navbar-fixed-top"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/"/>">Homestay
					Network</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<!-- <form class="navbar-form navbar-left col-lg-7 col-md-7 col-sm-7"
					role="search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Find something..."> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-default">Search</button>
						</span>
					</div>

				</form> -->

				<ul class="nav navbar-nav navbar-right">
					<li class="divider"></li>
					<li><c:if test="${authority == 'ROLE_GUEST'}">
							<a href='<c:url value='/guest/${username}' />'><strong>My
									Profile</strong></a>
						</c:if> <c:if test="${authority == 'ROLE_HOST'}">
							<a href='<c:url value='/host/${username}' />'><strong>My
									Profile</strong></a>
						</c:if></li>
					<li id="sepa"></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
					<li><a href="#"><span class="glyphicon glyphicon-envelope"></span></a></li>
					<li><a href="#" id="globe"><span
							class="glyphicon glyphicon-globe"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-lock"></span>
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<div class="navbar-content">
									<div class="row">
										<div class="col-md-5 col-sm-5 col-xs-5">
											<img src="<c:url value="/resources/images/avatar/${imageUrl}"/>" alt="Alternate Text"
												class="img-responsive" />
											<p class="text-center small">
												<a href="#">Change Photo</a>
											</p>
										</div>
										<div class="col-md-7 col-sm-7 col-xs-7">
											<span class="text-primary">${fullname}</span>
											<p class="text-muted small">${email}</p>
											<div class="divider"></div>
											<c:if test="${authority == 'ROLE_GUEST'}">
												<a class="btn btn-primary btn-sm active" href='<c:url value='/guest/${username}' />'><strong>My
														Profile</strong></a>
											</c:if>
											<c:if test="${authority == 'ROLE_HOST'}">
												<a class="btn btn-primary btn-sm active" href='<c:url value='/host/${username}' />'><strong>My
														Profile</strong></a>
											</c:if>
										</div>
									</div>
								</div>
								<div class="navbar-footer">
									<div class="navbar-footer-content">
										<div class="row">
											<div class="col-md-6 col-sm-6 col-xs-6">
												<a href="<c:url value="/account/setting/${username}" />"
													class="btn btn-default btn-sm">Account Setting</a>
											</div>
											<div class="col-md-6 col-sm-6 col-xs-6">
												<a href='<c:url value="/j_spring_security_logout" />'
													class="btn btn-default btn-sm pull-right">Sign Out</a>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
				</ul>
			</div>
		</div>
	</nav>
</div>