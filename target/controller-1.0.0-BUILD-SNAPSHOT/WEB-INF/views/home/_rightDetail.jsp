<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10 col-sm-10">
	<div class="panel panel-default" id="detail-homestay">
		<div class="panel-heading">
			<div class="row">
				<div class="col-md-10 col-sm-10 col-xs-10">
					<div class="media">
						<div class="media-title">
							<h3 class="media-heading">
								<span class="glyphicon glyphicon-user"></span><strong>Detail
									Page</strong>
							</h3>

						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="panel-body">
			<div class="panel-heading resume-heading">
				<div class="row">
					<c:forEach items="${listHomestayById}" var="hs">
						<div class="col-xs-12 col-sm-6">
							<div id="carousel" class="carousel slide" data-ride="carousel">
								<div class="carousel-inner">
									<c:forEach items="${homestayImages}" var="img">
										<div class="item ${img.imageStatus }" data-thumb="0">
											<img
												src="<c:url value="/resources/images/homestay/${img.imageUrl}"/>"
												width="700" height="400">

										</div>
									</c:forEach>
								</div>
							</div>
							<br />
							<div class="clearfix">
								<div id="thumbcarousel" class="carousel slide"
									data-interval="false">
									<div class="carousel-inner">
										<div class="item active">
											<c:forEach items="${homestayImages}" var="img">
												<div data-target="#carousel"
													data-slide-to="${img.sortOrder }" class="thumb thumbnail">
													<img
														src="<c:url value="/resources/images/homestay/${img.imageUrl}"/>"
														width="100" height="100">

												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<!-- /thumbcarousel -->
							</div>

						</div>

						<div class="col-xs-12 col-sm-6">
							<div class="well">
								<h4>
									<strong>Host: </strong>${hs.acc.fullName}
								</h4>
								<h5>
									<strong>Email: </strong>${hs.acc.emailAddress}
								</h5>
								<h5>
									<strong>Mobile: </strong>${hs.acc.phoneNumber}
								</h5>
								<hr />
								<h4>
									<strong>${hs.homestayTitle }</strong>
								</h4>
								<p>${hs.homestayAbout }</p>

								<h4>
									<strong>Address: </strong>
									<h5>${hs.homestayAddress }</h5>
								</h4>
								<h4>
									<strong>House Rules: </strong>
									<h5>${hs.homestayRule }</h5>
								</h4>
								<div class="social-buttons">
									<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i>
										Facebook</a> <a href="#" class="btn btn-tw"><i
										class="fa fa-twitter"></i> Twitter</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<hr />
			<h3>List Room</h3>

			<div class="table-responsive text-center" id="shopcart">
				<table id="cart"
					class="table table-hover table-condensed table-bordered">
					<thead>
						<tr>
							<th class="text-center" style="width: 5%">Image</th>
							<th class="text-center" style="width: 15%">Room Number</th>
							<th class="text-center" style="width: 15%">Room Type</th>
							<th class="text-center" style="width: 15%">Number Of Guest</th>
							<th class="text-center" style="width: 10%">BathRoom</th>
							<th class="text-center" style="width: 10%">Price</th>
							<th class="text-center" style="width: 5%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listRoomByHomestayIdAndAvailable}" var="rooms">
							<tr>
								<td><img
									src="<c:url value="/resources/images/room/${rooms.imageUrl}"/>"
									width="50" height="50"></td>
								<td data-th="Product">${rooms.roomNumber}</td>
								<td>${rooms.roomType.roomTypeName}</td>
								<td>${rooms.numberOfGuest }</td>
								<td>${rooms.haveBathroom }</td>
								<td data-th="Price">${rooms.roomType.roomPrice}$/day</td>
								<td class="actions" data-th=""><a
									href="<c:url value="/booking/${homestayId}&${username}&${rooms.roomId}" />"
									class="btn btn-success btn-sm">Booking</a></td>
							</tr>
						</c:forEach>


					</tbody>

				</table>
			</div>

			<hr />

			<h3>Comments (${countComment})</h3>
			<br />
			<div class="comment col-sm-12">
				<div class="form-cm">
					<c:url var="addAction"
						value="/comment/add/${homestayId}&${username}"></c:url>
					<form:form action="${addAction}" commandName="newComment"
						id="addnewcomment">
						<div class="input-group">
							<form:input path="homestay.homestayId" type="hidden"
								value="${homestayId}" />
							<form:input path="acc.accountId" type="hidden"
								value="${accountId}" />
							<form:input path="timeStamp" type="hidden" value="${getDate}" />
							<form:input type="text" class="form-control"
								placeholder="Leave your comment..." path="textContent"
								required="true" />
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit">Send</button>
							</span>
						</div>
					</form:form>
				</div>
				<br />
				<div class="list-cm">
					<c:forEach items="${listComment}" var="comment">
						<div class="media">
							<div class="media-left media-middle">
								<a href="#"> <img class="media-object img-circle"
									src="<c:url value="/resources/images/avatar/${comment.acc.imageUrl}"/>"
									width="50" height="50" alt="...">
								</a>
							</div>
							<div class="media-body">
								<h5 class="media-heading">${comment.acc.fullName }</h5>
								<a class="pull-right btn btn-danger btn-xs">Report</a>
								<p>${comment.textContent}</p>
								<small><a href="##" class="anchor-like">Like</a> </small>&nbsp;
								<small><a href="##"><i
										class="glyphicon glyphicon-thumbs-up"></i>1</a></small> <i href="#"
									class="anchor-time"> &nbsp;&nbsp;51 mins</i>
							</div>
						</div>
					</c:forEach>

				</div>
				<br />

			</div>
		</div>
	</div>


</div>
