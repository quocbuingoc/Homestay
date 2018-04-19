<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Create new homestay</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery-ui-timepicker-addon.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/jquery-ui.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/css/jquery-ui-timepicker-addon.css" />"
	rel="stylesheet" type="text/css" />
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/style2.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/host.css" />" rel="stylesheet" type="text/css" />
<script>
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
	

	$(document).ready(function(){
		$("#datepicker").datetimepicker({
			dateFormat : "dd/mm/yy",
			timeFormat : "hh:mm:ss",
			controlType : 'select',
			oneLine : true
		});
	});
</script>
</head>
<body>
	<div class="wrapper">
		<!-- Menu header -->
		<jsp:include page="../layout/_menuHeader.jsp" />

		<div class="container" id="content">
			<div class="row">
				<jsp:include page="../layout/_leftMenuHost.jsp" />
				<jsp:include page="_createHomestay.jsp" />
			</div>
		</div>
		<br> <a id="back-to-top" href="#"
			class="btn btn-primary btn-lg back-to-top" role="button"><span
			class="glyphicon glyphicon-chevron-up"></span></a>
	</div>
</body>
</html>