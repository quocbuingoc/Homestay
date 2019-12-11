<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-2 col-md-2">
	<div id="avatar">
		<img class="img-responsive thumbnail" src="<c:url value="/resources/images/avatar/${imageUrl}"/>" style="width:300px; height:160px;">
		<p class="text-center small">
			<a href="#">Change Your Photo</a>
		</p>
	</div>
	<hr/>
	<ul id="sidebar" class="nav nav-stacked">
		<li><a href='<c:url value='/guest/${username}' />'><span class="glyphicon glyphicon-envelope"></span>
				List Booked</a></li>
		<li><a href='<c:url value='/account/setting/${username}' />'><span class="glyphicon glyphicon-user"></span>
				Account Settings</a></li>
		
	</ul>
</div>