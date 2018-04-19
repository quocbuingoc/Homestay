<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-3 col-md-3 col-xs-12">
	<div id="midCol">
		<div class="panel panel-default" id="feeds">
			<div class="panel-heading">
				<strong><span class="font-panel-gray">NEWS FEED</span></strong>
			</div>
			<div class="panel-body">
				<c:forEach var="homestay" items="${listHomestay}">
					<div class="media">
						<div class="media-left">
							<a href="#"> <img class="media-object photo-profile"
								src="<c:url value="/resources/images/homestay/${homestay.imageUrl}"/>"
								width="70" height="55" alt="...">
							</a>
						</div>
						<div class="media-body">
							<a href="#" class="anchor-username">
								<h5 class="media-heading">${homestay.homestayTitle}</h5>
							</a> <span class="anchor-time">51 minutes</span>
						</div>
					</div>
				</c:forEach>


			</div>
			 
		</div>

		<div class="panel panel-default" id="hosts">
			<div class="panel-heading">
				<div class="panel-title">
					<strong><span class="font-panel-gray">HOSTS
							(${countAcc})</span></strong>
				</div>
			</div>
			<div class="panel-body">
				<c:forEach var="acc" items="${listAccount}">
					<div class="media">
						<div class="media-left">
							<a href="#"> <img class="media-object photo-profile"
								src="<c:url value="/resources/images/avatar/${acc.imageUrl}"/>"
								width="40" height="40" alt="...">
							</a>
						</div>
						<div class="media-body">
							<a href="#" class="anchor-username">
								<h6 class="media-heading">${acc.fullName}</h6>
							</a> <span class="anchor-time">Online</span>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
		<div class="well" id="ads">
			<img class="img-responsive"
				src="<c:url value="/resources/images/advertise/advertise-here.png"/>">
		</div>
		<div class="well">The new Bootstrap 3 is a smaller build. The
			separate Bootstrap base and responsive.css files have now been merged
			into one. There is no more fixed grid, only fluid..</div>
		<div class="well">Well, that's it for now Jim.</div>
		<div class="well">A big design trend for 2013 is "flat" design.
			Gone are the days of excessive gradients and shadows. Designers are
			producing cleaner flat designs, and Bootstrap 3 takes advantage of
			this minimalist trend. Aliquam in felis sit amet augue.</div>
	</div>
</div>