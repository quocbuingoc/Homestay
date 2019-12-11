<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-sm-2 col-md-2">
	<div id="avatar">
		<img class="img-responsive thumbnail" src="<c:url value="/resources/images/avatar/${imageUrl}"/>" style="width:300px; height:160px;" >
		<p class="text-center" style="color:gray; font-weight:700; padding-top:3px;">
			${email}
		</p>
	</div>
	<hr/>
	<ul id="sidebar" class="nav nav-stacked">
		<li><a href="#" style="color:gray; font-weight:500;"><span class="glyphicon glyphicon-envelope" style="color:teal;"></span>
				Messages</a></li>
		<li><a href="#" style="color:gray; font-weight:500;"><span class="glyphicon glyphicon-user" style="color:teal;"></span>
				Friends</a></li>

		<li><a href="#" style="color:gray; font-weight:500;"><span class="glyphicon glyphicon-picture" style="color:teal;"></span>
				Photos</a></li>
		<li><a href="#" style="color:gray; font-weight:500;"><span class="glyphicon glyphicon-lock" style="color:teal;"></span>
				Setting</a></li>
		<li><a style="color:gray; font-weight:500;" href='<c:url value="/j_spring_security_logout" />'><span class="glyphicon glyphicon-log-out" style="color:teal;"></span>
				Sign Out</a></li>
	</ul>
</div>