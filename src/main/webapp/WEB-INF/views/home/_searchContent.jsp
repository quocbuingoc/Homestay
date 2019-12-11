<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-7 col-sm-7 col-md-push-2 col-sm-push-2">
	<div id="search" style="margin-bottom: 15px;">
		<div class="find" style="padding-bottom: 15px;">
			<strong><span class="font-panel-gray">FIND HOMESTAYS</span></strong>
		</div>
		<c:url var="searchAction" value="/search"></c:url>
		<form:form action="${searchAction}" method="GET"
			class="form-horizontal" role="form">
			<div class="form-group"
				style="padding-right: 15px; padding-left: 15px;">
				<textarea class="form-control"
					placeholder="Find homestay, destination,..." name="address"
					id="address"></textarea>
			</div>
			<div class="form-group row">
				<div class="col-md-4 col-sm-4 col-xs-4">
					<select class="form-control" id="sel1" name="cityName">
						<option disabled selected>-- Choose your city --</option>
						<option>Da Nang</option>
						<option>Hoi An</option>
						<option>Ho Chi Minh</option>
						<option>Ha Noi</option>
					</select>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-4">
					<select class="form-control" id="sel1">
						<option disabled selected>-- Number of guest --</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				</div>
				<div class="col-md-4 col-sm-4 col-xs-4">
					<div id="search-btn" class="form-group"
						style="padding-right: 15px; padding-left: 15px;">
						<button class="btn btn-primary pull-right" type="submit">Search</button>
					</div>
				</div>

			</div>


		</form:form>
	</div>
	<hr />
	<c:choose>
		<c:when test="${empty address}">
			<h2>No results for keyword: "${address }"</h2>
		</c:when>
		<c:otherwise>
			<h3>We have "${countSearch}" results with keywords: "${address}"</h3>
			<br />
			<c:forEach var="homestay" items="${search}">
				<div class="panel panel-default" id="status">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-10 col-sm-10 col-xs-10">
								<div class="media">
									<div class="media-left">
										<a href="#"> <img class="media-object photo-profile"
											src="<c:url value="/resources/images/avatar/${homestay.acc.imageUrl}"/>"
											width="40" height="40" alt="...">
										</a>
									</div>
									<div class="media-body">
										<a href="#" class="anchor-username">
											<h4 class="media-heading">${homestay.acc.fullName}</h4>
										</a> <a href="#" class="anchor-time">51 minutes</a>
									</div>
								</div>
							</div>
							<div class="col-md-2 col-sm-2 col-xs-2" id="dropdown-chev">
								<div class="dropdown">
									<span class="dropdown-toggle" type="button"
										data-toggle="dropdown"> <i
										class="glyphicon glyphicon-chevron-down pull-right"></i>
									</span>
									<ul class="dropdown-menu" role="menu">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Action</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Another action</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Something else here</a></li>
										<li role="presentation" class="divider"></li>
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="#">Separated link</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<a
									href="<c:url value="/detail/homestay/${homestay.homestayId}&${username}" />">
									<img
									src="<c:url value="/resources/images/homestay/${homestay.imageUrl}"/>"
									class="img-responsive">
								</a>
							</div>
						</div>


						<div class="clearfix"></div>
						<hr>
						<h3>
							<a
								href="<c:url value="/detail/homestay/${homestay.homestayId}&${username}" />">${homestay.homestayTitle}</a>
						</h3>
						<p>
							<strong>Address:</strong> ${homestay.homestayAddress}
						</p>
						<p>${homestay.homestayAbout}</p>

						<hr>
						<div id="plugin">
							<ul class="list-inline">
								<li><a href="##" class="like-button"><i
										class="glyphicon glyphicon-thumbs-up"></i> Like</a>&nbsp;</li>
								<li class="btn-comment"><a href="##" id="show"><i
										class="glyphicon glyphicon-comment"></i> Comment</a>&nbsp;</li>
								<li><a href=""><i class="glyphicon glyphicon-share-alt"></i>
										Share</a></li>

							</ul>
						</div>
					</div>
					<div class="panel-footer" id="showForm">
						<div class="panel-listComment">
							<div class="bs-callout">
								<i class="glyphicon glyphicon-thumbs-up"></i> <a href="##"><small>Tran
										Na and 20 others</small></a>
							</div>
							<br>
							<div class="list">
								<div class="media">
									<div class="media-left">
										<a href="#"> <img class="media-object photo-profile"
											src="http://0.gravatar.com/avatar/38d618563e55e6082adf4c8f8c13f3e4?s=40&d=mm&r=g"
											width="40" height="40" alt="...">
										</a>
									</div>
									<div class="media-body">
										<a href="#" class="anchor-username">
											<h5 class="media-heading">
												Bayu Darmantra
												</h4>
										</a>

										<p>
											<small>Write something asda asd asd asd asda s d asda
												asd asd asd asd</small>
										</p>
										<small><a href="#" class="anchor-like">Like</a> </small>&nbsp;
										<small><a href="##"><i
												class="glyphicon glyphicon-thumbs-up"></i> 18</a></small> <i href="#"
											class="anchor-time"> &nbsp;&nbsp;51 mins</i>
									</div>
								</div>
								<div class="media">
									<div class="media-left">
										<a href="#"> <img class="media-object photo-profile"
											src="http://0.gravatar.com/avatar/38d618563e55e6082adf4c8f8c13f3e4?s=40&d=mm&r=g"
											width="40" height="40" alt="...">
										</a>
									</div>
									<div class="media-body">
										<a href="#" class="anchor-username">
											<h5 class="media-heading">
												Bayu Darmantra
												</h4>
										</a>

										<p>
											<small>Write something asda asd asd asd asda s d asda
												asd asd asd asd</small>
										</p>
										<small><a href="#" class="anchor-like">Like</a> </small>&nbsp;
										<small><a href="##"><i
												class="glyphicon glyphicon-thumbs-up"></i> </a></small> <i href="#"
											class="anchor-time"> &nbsp;&nbsp;51 mins</i>
									</div>
								</div>
							</div>
						</div>
						<form class="panel-comment">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Add a comment.."> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">Send</button>
								</span>
							</div>
						</form>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>


</div>