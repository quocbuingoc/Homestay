<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-2 col-md-2">
	<div id="avatar">
		<img class="img-responsive thumbnail"
			src="<c:url value="/resources/images/avatar/${imageUrl}"/>"
			style="width: 300px; height: 160px;">
		<p class="text-center small">
			<a href="#">Change Your Photo</a>
		</p>
	</div>
	<hr />
	<ul id="sidebar" class="nav nav-stacked">
		<li><a href='<c:url value='/host/${username}' />'><span
				class="glyphicon glyphicon-envelope"></span> Overview</a></li>

		<li><a href='<c:url value='/host/homestay/${username}' />'><span
				class="glyphicon glyphicon-user"></span> Homestay</a></li>
		<li><c:choose>
				<c:when test="${!empty listHomestay}">
					<a href='<c:url value='/host/room/${username}' />'><span
						class="glyphicon glyphicon-user"></span> Room</a>
				</c:when>
				<c:otherwise>
					<a href="" data-toggle="tooltip" data-placement="right"
						title="Please create a homestay first!" class="disabled"><span
						class="glyphicon glyphicon-user"></span> Room</a>
				</c:otherwise>
			</c:choose></li>
		<li><c:choose>
				<c:when test="${!empty listHomestay}">
					<a href='<c:url value='/host/booked/${username}' />'><span
						class="glyphicon glyphicon-user"></span> List Booking</a>
				</c:when>
				<c:otherwise>
					<a href="" data-toggle="tooltip" data-placement="right"
						title="Please create a homestay first!" class="disabled"><span
						class="glyphicon glyphicon-user"></span> List Booking</a>
				</c:otherwise>
			</c:choose></li>
		<li><c:choose>
				<c:when test="${!empty listHomestay}">
					<a href='<c:url value='/host/homestay-image/${username}' />'><span
						class="glyphicon glyphicon-user"></span> Homestay Image</a>
				</c:when>
				<c:otherwise>
					<a href="" data-toggle="tooltip" data-placement="right"
						title="Please create a homestay first!" class="disabled"><span
						class="glyphicon glyphicon-user"></span> Homestay Image</a>
				</c:otherwise>
			</c:choose></li>
	</ul>
</div>