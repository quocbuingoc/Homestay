<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-2 col-md-2">
	<div id="avatar">
		<img class="img-responsive thumbnail" src="//placehold.it/300x300">
		<p class="text-center small">
			<a href="#">Change Your Photo</a>
		</p>
	</div>
	<hr/>
	<ul id="sidebar" class="nav nav-stacked">
		<li><a href='<c:url value='/host/${user}' />'><span class="glyphicon glyphicon-envelope"></span>
				Overview</a></li>
		<li ><a href='<c:url value='/host/homestay/${user}' />'><span class="glyphicon glyphicon-user"></span>
				Homestays</a></li>

		<li><a href='<c:url value='/host/room/${user}' />'><span class="glyphicon glyphicon-picture"></span>
				Rooms</a></li>
		<li class="active"><a href='<c:url value='/host/facility/${user}' />'><span class="glyphicon glyphicon-lock"></span>
				Facilities</a></li>
		
	</ul>
</div>