
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
				<div class="content text-center">
					<h2>Congratulation, You have booked successful !</h2>
					<h4><i>Check your cart in Profile</i></h4>
					<a href="<c:url value="/"/>" class="btn btn-primary">Back to Home page</a>
				</div>
			</div>
		</div>
		<a id="back-to-top" href="#"
			class="btn btn-primary btn-lg back-to-top" role="button"><span
			class="glyphicon glyphicon-chevron-up"></span></a>
	</div>
</body>
</html>
